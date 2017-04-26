package cn.edu.upc.yb.integrate.InstructorEvaluate.controller;

import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.StudentDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Student;
import cn.edu.upc.yb.integrate.common.util.JsonWebToken;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by lhy95 on 2017/4/26.
 */
@RestController
@RequestMapping("/instructor")
public class InstructorAuthController {

    @Autowired
    private JsonWebToken jsonWebToken;

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/login")
    public Object doLogin(String number, String password) {
        Iterable<Student> students = studentDao.findByNumberAndPassword(number, password);
        Iterator<Student> studentIterator = students.iterator();
        Student student;
        if (studentIterator.hasNext()) {
            student = studentIterator.next();
        } else {
            return "{status: 1}";
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", student);
        HashMap rs = new HashMap();
        rs.put("status", 0);
        rs.put("data", jsonWebToken.generateToken(map));
        return rs;
    }

    @RequestMapping("/testtoken")
    public Object doCheck(String token) {
        System.out.println(token);
        Claims claims = jsonWebToken.getClaimsFromToken(token);
        return claims.get("username");
    }

}
