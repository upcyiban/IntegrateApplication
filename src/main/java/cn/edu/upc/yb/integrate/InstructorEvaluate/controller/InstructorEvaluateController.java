package cn.edu.upc.yb.integrate.InstructorEvaluate.controller;

import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Student;
import cn.edu.upc.yb.integrate.InstructorEvaluate.service.InstructorService;
import cn.edu.upc.yb.integrate.common.util.JsonWebToken;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lhy95 on 2017/4/26.
 */
@RestController
@RequestMapping("/instructor")
public class InstructorEvaluateController {

    @Autowired
    private InstructorService instructorService;

    @RequestMapping("/submitEvaluate")
    public Object submitEvaluate(String token, Integer score, Integer instructorId, String message) {
        if (token == null || score == null || instructorId == null) {
            return "{status: 1}";
        }
        return instructorService.saveRecord(token, score, instructorId, message);
    }

    @RequestMapping("/showEvaluate")
    public Object showAllEvaluate() {
        return instructorService.getAllEvaluate();
    }
}
