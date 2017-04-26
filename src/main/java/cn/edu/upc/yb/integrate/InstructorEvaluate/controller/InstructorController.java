package cn.edu.upc.yb.integrate.InstructorEvaluate.controller;

import cn.edu.upc.yb.integrate.InstructorEvaluate.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by lhy95 on 2017/4/26.
 */
@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @RequestMapping("/getInstructor")
    public HashMap<String, Object> getInstructor() {
        return instructorService.getAllInstructor();
    }
}
