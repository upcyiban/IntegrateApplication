package cn.edu.upc.yb.integrate.InstructorEvaluate.controller;

import cn.edu.upc.yb.integrate.InstructorEvaluate.service.InstructorAuthService;
import cn.edu.upc.yb.integrate.common.util.JsonWebToken;
import io.jsonwebtoken.Claims;
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

    private final JsonWebToken jsonWebToken;
    private final InstructorAuthService instructorAuthService;

    @Autowired
    public InstructorAuthController(JsonWebToken jsonWebToken, InstructorAuthService instructorAuthService) {
        this.jsonWebToken = jsonWebToken;
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
}
