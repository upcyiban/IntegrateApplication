package cn.edu.upc.yb.integrate.InstructorEvaluate.service;

import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.InstructorDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.RecordDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.StudentDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dto.InstructorItem;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Instructor;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Record;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Student;
import cn.edu.upc.yb.integrate.common.storage.StorageService;
import cn.edu.upc.yb.integrate.common.util.JsonWebToken;
import io.jsonwebtoken.Claims;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by lhy95 on 2017/4/26.
 */
@Service
public class InstructorService {

    private final InstructorDao instructorDao;
    private final JsonWebToken jsonWebToken;
    private final RecordDao recordDao;
    private final StorageService storageService;
    private final StudentDao studentDao;

    @Autowired
    public InstructorService(InstructorDao instructorDao, JsonWebToken jsonWebToken, RecordDao recordDao, StorageService storageService, StudentDao studentDao) {
        this.instructorDao = instructorDao;
        this.jsonWebToken = jsonWebToken;
        this.recordDao = recordDao;
        this.storageService = storageService;
        this.studentDao = studentDao;
    }

    // 获取所有的辅导员，因为是二级菜单，需要整理成json格式
    public HashMap<String, Object> getAllInstructor() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        // 获取所有辅导员信息
        Iterable<Instructor> instructors = instructorDao.findAll();
        // 遍历Iterable
        for (Instructor instructor : instructors) {
            // 如果hashmap中没有这个key，则创建key对应空数组
            map.computeIfAbsent(instructor.getAcademy(), k -> new ArrayList());
            List temp = (ArrayList) map.get(instructor.getAcademy());
            temp.add(instructor);
        }
        return map;
    }

    // 存一条评价
    public Map<String, java.io.Serializable> saveRecord(String token, Integer score, String message, Integer flag) {
        Map<String, java.io.Serializable> rs = new HashMap<String, java.io.Serializable>();

        if (token == null || score == null || flag == null) {
            rs.put("status", 1);
            rs.put("errorMsg", "数据不完整");
            return rs;
        }

        // 鉴定是否是学生 是则获得学号，否则则获得字符串0
        String studentNumber = getStudentNumber(token);
        if (studentNumber.equals("0")) {
            rs.put("status", 2);
            rs.put("errorMsg", "身份异常");
            return rs;
        }

        // 学生评价条数限制
        List recordList = (List) recordDao.findByStudentNumber(studentNumber);
        if (recordList.size() >= 2) {
            rs.put("status", 3);
            rs.put("errorMsg", "评价次数过多");
            return rs;
        }

        // 获取辅导员ID
        int instructorId = getInstructorId(token, flag);
        if (instructorId == 0) {
            rs.put("status", 4);
            rs.put("errorMsg", "辅导员ID异常");
            return rs;
        }

        // 学生对某个辅导员只能评价一次
        List studentToOneInstructorRecordList = (List) recordDao.findByStudentNumberAndInstructorId(studentNumber, instructorId);
        if (studentToOneInstructorRecordList.size() >= 1) {
            rs.put("status", 5);
            rs.put("errorMsg", "已经评价过该辅导员");
            return rs;
        }

        Record record = new Record(studentNumber, instructorId, score, message);
        recordDao.save(record);
        rs.put("status", 0);
        return rs;
    }

    // 获取所有的评价
    public Map getAllEvaluate(String token) {
        Map rs = new HashMap();

        // 鉴权
        if (!isAdmin(token)) {
            rs.put("status", 1);
            rs.put("errorMsg", "身份异常");
            return rs;
        }

        ArrayList<InstructorItem> instructorList = new ArrayList<>();

        Iterable<Instructor> instructors = instructorDao.findAll();
        for (Instructor instructor : instructors) {
            // 获取该辅导员的分数
            double score = calculateScore(instructor.getId());

            String voteRate = calculateVote(instructor.getName(), instructor.getId());

            InstructorItem instructorItem = new InstructorItem(instructor, score, voteRate);
            instructorList.add(instructorItem);
        }

        rs.put("status", 0);
        rs.put("data", instructorList);
        return rs;
    }

    private String calculateVote(String name, int instructorId) {
        int total;

        // 查找该辅导员是多少人的第一辅导员
        List<Student> students = (List<Student>) studentDao.findByInstructorName(name);
        if (students != null) {
            total = students.size();
        } else {
            total = 0;
        }

        // 查找该辅导员是多少人的第二辅导员，并与之前的相加
        students = (List<Student>) studentDao.findBySecondInstructor(name);
        if (students != null) {
            total += students.size();
        } else {
            total += 0;
        }


        students = (List<Student>) studentDao.findByThirdInstructor(name);
        if (students != null) {
            total += students.size();
        } else {
            total += 0;
        }
        // 如果被除数是0，直接返回0.00%
        if (total == 0) {
            return "0.00%";
        }

        // 查看该辅导员有多少人已评价
        List<Record> records = (List<Record>) recordDao.findByInstructorId(instructorId);
        int voteNumber;
        if (records != null) {
            voteNumber = records.size();
        } else {
            voteNumber = 0;
        }

        // 计算投票率，并保留两位小数
        double rate = (double)voteNumber / total;
        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(2);
        return nt.format(rate);
    }

    // 计算某个辅导员的平均分
    private double calculateScore(int instructorId) {
        Iterable<Record> records = recordDao.findByInstructorId(instructorId);
        int num = 0;
        double total = 0;
        for (Record record : records) {
            total += record.getScore();
            num++;
        }
        if (num == 0) {
            return 0;
        } else {
            return total / num;
        }
    }

    // 从excel文件里导入数据到数据库然后删除文件
    public Map<String, java.io.Serializable> importDataFromExcel(MultipartFile file, String token) throws IOException {
        // 用来返回结果
        HashMap<String, java.io.Serializable> rs = new HashMap<String, java.io.Serializable>();

        // 鉴权
        if (!isAdmin(token)) {
            rs.put("status", 0);
            rs.put("errorMsg", "身份异常");
            return rs;
        }

        // 存储excel文件，获取其文件名
        String fileName = storeExcelFile(file);

        // 导入新数据就清除旧数据
        instructorDao.deleteAll();

        // 获取excel文件
        File tempFile = new File("file/img/" + fileName);
        Workbook wb = new HSSFWorkbook(new FileInputStream(tempFile));

        // 读取excel中的有效信息，以数组返回给instructors并存进数据库
        Iterable<Instructor> instructors = readExcelValue(wb);
        instructorDao.save(instructors);

        //删除上传的临时文件
        if (tempFile.exists()) {
            tempFile.delete();
        }

        rs.put("status", 0);
        return rs;
    }

    // 读取excel文件，返回辅导员集合
    private Iterable<Instructor> readExcelValue(Workbook wb) {
        ArrayList<Instructor> instructors = new ArrayList<Instructor>();

        // 获取默认的表格
        Sheet sheet = wb.getSheet("Sheet1");

        int rowNumber = sheet.getPhysicalNumberOfRows();

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rowNumber; i++) {
            Instructor instructor = new Instructor();
            Cell cell = sheet.getRow(i).getCell(0);
            instructor.setAcademy(formatter.formatCellValue(cell));
            cell = sheet.getRow(i).getCell(1);
            instructor.setNumber(formatter.formatCellValue(cell));
            cell = sheet.getRow(i).getCell(2);
            instructor.setName(formatter.formatCellValue(cell));
            instructors.add(instructor);
        }

        return instructors;
    }

    // 鉴定是否是学生，返回学号 不是则返回0
    private String getStudentNumber(String token) {
        Claims claims = jsonWebToken.getClaimsFromToken(token);
        HashMap studentMap;
        if (claims != null) {
            if (claims.get("role").equals("student")) {
                studentMap = (HashMap) claims.get("user");
                return (String) studentMap.get("number");
            }
        }
        return "0";
    }

    // 获取辅导员ID，从token中
    private Integer getInstructorId(String token, Integer flag) {
        Claims claims = jsonWebToken.getClaimsFromToken(token);
        if (claims != null && flag == 1) {
            return (Integer) claims.get("instructorId");
        } else if (claims != null && flag == 2){
            return (Integer) claims.get("secondInstructorId");
        }
        return 0;
    }

    // 存储上传的excel表
    private String storeExcelFile(MultipartFile file) {
        String fileName = "instructor" + new Date().getTime();
        storageService.store(file, fileName);
        return fileName;
    }

    private Boolean isAdmin(String token) {
        Claims claims = jsonWebToken.getClaimsFromToken(token);
        if (claims != null) {
            if (claims.get("role").equals("admin")) {
                return true;
            }
        }
        return false;
    }

    // 获取某个辅导员的评价详单
    public Map getEvaluateDetail(String token, String number) {
        Map rs = new HashMap();

        // 先鉴权，要求是管理员才能看
        if (!isAdmin(token)) {
            rs.put("status", 1);
            rs.put("errorMsg", "权限异常");
            return rs;
        }

        // 查询该辅导员
        Instructor instructor;
        Iterable<Instructor> instructors = instructorDao.findByNumber(number);
        Iterator<Instructor> instructorIterator = instructors.iterator();
        if (instructorIterator.hasNext()) {
            instructor = instructorIterator.next();
        } else {
            rs.put("status", 2);
            rs.put("errorMsg", "无该辅导员");
            return rs;
        }

        // 获取该辅导员带的所有学生的学号
        List noVoteStudentList = new ArrayList();
        Iterable<Student> students = studentDao.findByInstructorName(instructor.getName());
        for (Student student : students) {
            noVoteStudentList.add(student.getNumber());
        }
        students = studentDao.findBySecondInstructor(instructor.getName());
        for (Student student : students) {
            noVoteStudentList.add(student.getNumber());
        }

        // 获取该辅导员的评价记录
        Iterable<Record> records = recordDao.findByInstructorId(instructor.getId());

        for (Record record : records) {
            if (noVoteStudentList.contains(record.getStudentNumber())) {
                noVoteStudentList.remove(record.getStudentNumber());
            }
        }

        rs.put("status", 0);
        rs.put("data", records);
        rs.put("noVoteList", noVoteStudentList);
        return rs;
    }
}
