package cn.edu.upc.yb.integrate.InstructorEvaluate.controller;

import cn.edu.upc.yb.integrate.InstructorEvaluate.service.InstructorAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by lhy95 on 2017/4/26.
 */
@RestController
@RequestMapping("/instructor")
public class InstructorAuthController {

    private final InstructorAuthService instructorAuthService;

    @Autowired
    public InstructorAuthController(InstructorAuthService instructorAuthService) {
        this.instructorAuthService = instructorAuthService;
    }

    @RequestMapping("/login")
    public Map doLogin(String number, String password) {
        return instructorAuthService.studentLogin(number, password);
    }

    @RequestMapping("/admin/login")
    public Map doAdminLogin(String username, String password) {
        return instructorAuthService.adminLogin(username, password);
    }

    @RequestMapping("/loginbyyiban")
    public Map authByYiban(String verify_request) {
        return instructorAuthService.authByYiban(verify_request);
    }
}
