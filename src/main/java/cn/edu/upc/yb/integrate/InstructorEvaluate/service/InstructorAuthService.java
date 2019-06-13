package cn.edu.upc.yb.integrate.InstructorEvaluate.service;

import cn.edu.upc.yb.integrate.InstructorEvaluate.config.InstructorConfig;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.InstructorAdminDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.InstructorDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.StudentDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Admin;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Instructor;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Student;
import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.util.JsonWebToken;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by lhy95 on 2017/4/29.
 */
@Service
@Slf4j
public class InstructorAuthService {

    private final StudentDao studentDao;
    private final JsonWebToken jsonWebToken;
    private final InstructorAdminDao instructorAdminDao;
    private final YibanOAuth yibanOAuth;
    private final InstructorConfig instructorConfig;
    private final InstructorDao instructorDao;

    @Autowired
    public InstructorAuthService(StudentDao studentDao, JsonWebToken jsonWebToken, InstructorAdminDao instructorAdminDao, YibanOAuth yibanOAuth, InstructorConfig instructorConfig, InstructorDao instructorDao) {
        this.studentDao = studentDao;
        this.jsonWebToken = jsonWebToken;
        this.instructorAdminDao = instructorAdminDao;
        this.yibanOAuth = yibanOAuth;
        this.instructorConfig = instructorConfig;
        this.instructorDao = instructorDao;
    }

    public Map studentLogin(String number, String password) {
        HashMap rs = new HashMap();

        // 查对应的学生信息，若没有返回状态码1
        Iterable<Student> students = studentDao.findByNumberAndPassword(number, password);
        Iterator<Student> studentIterator = students.iterator();
        Student student;
        if (studentIterator.hasNext()) {
            student = studentIterator.next();
        } else {
            // 账户密码错误，返回错误码1
            rs.put("status", 1);
            return rs;
        }

        return dealLoginProcess(rs, student);
    }

    public Map adminLogin(String username, String password) {
        HashMap rs = new HashMap();
        Iterable<Admin> admins = instructorAdminDao.findByUsernameAndPassword(username, password);
        Iterator<Admin> adminIterator = admins.iterator();
        Admin admin;
        if (adminIterator.hasNext()) {
            admin = adminIterator.next();
        } else {
            rs.put("status", 1);
            return rs;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", admin);
        map.put("role", "admin");

        rs.put("status", 0);
        rs.put("data", jsonWebToken.generateToken(map));
        rs.put("role", "admin");

        return rs;
    }

    // 使用易班授权获得用户学号，返回本系统的token
    public Map authByYiban(String yibanToken) {
        HashMap rs = new HashMap();

        // yibanTokenResult是通用模块解析出来的map对象 status表示解析状态 0是正常
        Map yibanTokenResult = yibanOAuth.dealYibanToken(yibanToken, instructorConfig.appid, instructorConfig.appkey);
        // 如果解析正常，取出其中的data部分继续操作，否则返回错误信息
        if ((int) yibanTokenResult.get("status") == 0) {
            Map yibanTokenData = (Map) yibanTokenResult.get("data");
            if (yibanTokenData.get("visit_oauth") instanceof Boolean && (!((Boolean) yibanTokenData.get("visit_oauth")))) {
                // 未授权，重定向去授权
                rs.put("status", 1);
                rs.put("errorMsg", "未授权，请引导用户授权");
                return rs;
            } else {
                Map yibanOauthMap = (Map) yibanTokenData.get("visit_oauth");
                long currentTime = new Date().getTime() / 1000;
                // 校验token是否过期
                if (Integer.parseInt((String) yibanOauthMap.get("token_expires")) > currentTime) {
                    String yibanAccessToken = (String) yibanOauthMap.get("access_token");
                    try {
                        String studentNumber = getStudentNumber(yibanAccessToken);
                        // 如果等于0 怕是接口有毛病
                        if (studentNumber==null||studentNumber.length()<4) {
                            // INFO  2019/6/13 18:20 liliangbin  辅导员或是其他教职员工是没有学号的，我们拿不到值。如果我们需要用到教职员工登录的时候可以在这个地方判断有无，换为获取他的工号

                            rs.put("status", 2);
                            rs.put("errorMsg", "接口故障");
                            return rs;
                        }

                        // 这里是正常的返回
                        Iterable<Student> students = studentDao.findByNumber(studentNumber);
                        if (students==null){
                            // 找不到该用户，可能上报的excel中数据有问题
                            rs.put("status", 3);
                            rs.put("errorMsg", "数据库中查不到该用户，可能上报的excel中没有该同学");
                            return rs;
                        }
                        Iterator<Student> studentIterator = students.iterator();
                        Student student;
                        if (studentIterator.hasNext()) {
                            student = studentIterator.next();
                            log.info(" a student is going to auth " + student.getNumber());

                        } else {
                            // 找不到该用户，可能上报的excel中数据有问题
                            rs.put("status", 3);
                            rs.put("errorMsg", "数据库中查不到该用户，可能上报的excel中没有该同学");
                            return rs;
                        }
                        return dealLoginProcess(rs, student);

                    } catch (IOException e) {
                        e.printStackTrace();
                        rs.put("status", 2);
                        rs.put("errorMsg", "接口故障");
                        return rs;
                    }
                }
            }

            rs.put("status", 1);
            rs.put("errorMsg", "token已过期");
            return rs;
        } else {
            rs.put("status", 2);
            rs.put("errorMsg", "解析token失败");
            return rs;
        }
    }

    private String getStudentNumber(String accessToken) throws IOException {
        String url = "https://openapi.yiban.cn/user/verify_me";
        String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()

        String query = String.format("access_token=%s",
                URLEncoder.encode(accessToken, charset));

        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(response));
        String read;

        while ((read = br.readLine()) != null) {
            sb.append(read);
        }

        br.close();

        // 获取易班服务器返回的字符串到rs字符串里
        String rs = sb.toString();
        Gson gson = new Gson();
        try {
            Map messageMsp = gson.fromJson(rs, Map.class);
//            System.out.println(messageMsp);
            if (messageMsp.get("status").equals("success")) {
                return (String) ((Map) messageMsp.get("info")).get("yb_studentid");
            } else {
                return "0";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return "0";
        }
    }

    // 处理登录细节流程，包括查找该学生对应的辅导员，第二辅导员，存进token中
    private HashMap dealLoginProcess(HashMap rs, Student student) {
        // 根据学生对象上的辅导员姓名，查找对应的辅导员
        String instructorName = student.getInstructorName();
        log.info("structor_name - 00"+instructorName+ "student number "+student.getNumber());
        Iterable<Instructor> instructors = instructorDao.findByName(instructorName);
        Iterator<Instructor> instructorIterator = instructors.iterator();
        Instructor instructor;
        if (instructorIterator.hasNext()) {
            instructor = instructorIterator.next();
            rs.put("instructorName", instructor.getName());
        } else {
            // 如果没找到对应辅导员，返回错误码2
            rs.put("status", 2);
            return rs;
        }

        // 构造要加密的map
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", student);
        map.put("role", "student");
        map.put("instructorId", instructor.getId());

        // 如果第二辅导员不为空
        if (!"".equals(student.getSecondInstructor())) {
            String secondInstructorName = student.getSecondInstructor();
            Iterable<Instructor> secondInstructors = instructorDao.findByName(secondInstructorName);
            Iterator<Instructor> secondInstructorIterator = secondInstructors.iterator();
            Instructor secondInstructor;
            if (secondInstructorIterator.hasNext()) {
                secondInstructor = secondInstructorIterator.next();
                map.put("secondInstructorId", secondInstructor.getId());
                rs.put("hasSecond", true);
                rs.put("secondInstructorName", secondInstructor.getName());
            } else {
                // 如果没找到对应的二号辅导员，异常如何处理
                rs.put("hasSecond", false);
            }
        }
        /*第三个辅导员*/
        else if (!"".equals(student.getThirdInstructor())) {
            String thirdInstructor = student.getThirdInstructor();
            Iterable<Instructor> thirdIns = instructorDao.findByName(thirdInstructor);
            Iterator<Instructor> thirdInstructorIterator = thirdIns.iterator();
            Instructor third;
            if (thirdInstructorIterator.hasNext()) {
                third = thirdInstructorIterator.next();
                map.put("thirdInstructorId", third.getId());
                rs.put("hasThird", true);
                rs.put("thirdInstructorName", third.getName());
            } else {
                // 如果没找到对应的三号辅导员，异常如何处理
                rs.put("hasThird", false);
            }
        } else {
            rs.put("hasThird", false);
        }

        rs.put("status", 0);
        rs.put("data", jsonWebToken.generateToken(map));
        return rs;
    }
}
