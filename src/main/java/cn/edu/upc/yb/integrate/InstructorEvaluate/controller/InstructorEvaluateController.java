package cn.edu.upc.yb.integrate.InstructorEvaluate.controller;

import cn.edu.upc.yb.integrate.InstructorEvaluate.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by lhy95 on 2017/4/26.
 */
@RestController
@RequestMapping("/instructor")
public class InstructorEvaluateController {

    @Autowired
    private InstructorService instructorService;

    @RequestMapping("/submitEvaluate")
    public Object submitEvaluate(String token, Integer score, String message, Integer flag) {
        return instructorService.saveRecord(token, score, message, flag);
    }

    @RequestMapping("/showEvaluate")
    public Map showAllEvaluate(String token) {
        return instructorService.getAllEvaluate(token);
    }

    @RequestMapping("/showEvaluateDetail")
    public Map showEvaluateDetail(String token, String number) {
        return instructorService.getEvaluateDetail(token, number);
    }
}
