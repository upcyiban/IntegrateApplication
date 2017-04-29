package cn.edu.upc.yb.integrate.InstructorEvaluate.service;

import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.InstructorAdminDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.StudentDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Admin;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Student;
import cn.edu.upc.yb.integrate.common.util.JsonWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by lhy95 on 2017/4/29.
 */
@Service
public class InstructorAuthService {

    private final StudentDao studentDao;
    private final JsonWebToken jsonWebToken;
    private final InstructorAdminDao instructorAdminDao;

    @Autowired
    public InstructorAuthService(StudentDao studentDao, JsonWebToken jsonWebToken, InstructorAdminDao instructorAdminDao) {
        this.studentDao = studentDao;
        this.jsonWebToken = jsonWebToken;
        this.instructorAdminDao = instructorAdminDao;
    }

    public Map studentLogin(String number, String password) {
        HashMap rs = new HashMap();

        Iterable<Student> students = studentDao.findByNumberAndPassword(number, password);
        Iterator<Student> studentIterator = students.iterator();
        Student student;
        if (studentIterator.hasNext()) {
            student = studentIterator.next();
        } else {
            rs.put("status", 1);
            return rs;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", student);
        map.put("role", "student");

        rs.put("status", 0);
        rs.put("data", jsonWebToken.generateToken(map));
        return rs;
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

        return rs;
    }
}
