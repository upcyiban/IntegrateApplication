package cn.edu.upc.yb.integrate.sighup.controller;

import cn.edu.upc.yb.integrate.sighup.model.SighUp;
import cn.edu.upc.yb.integrate.sighup.repository.SighUpRepository;
import cn.edu.upc.yb.integrate.sighup.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jaxlying on 2016/9/27.
 */
@Controller
@RequestMapping("/sighup")
public class SighupController {

    @Autowired
    private SighUpRepository sighUpRepository;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String send(Model model,String name,String major,String sex,String detail,String method){
        SighUp sighUp = new SighUp(name, sex, method,  detail,  major);
        sighUpRepository.save(sighUp);
        MailUtils mailUtils = new MailUtils();
        mailUtils.send("upcybdevelopment@outlook.com","name: " + name + "</br>" +
                "性别:" + sex + "</br>" +
                 "专业班级: " + major +"</br>" +
                "个人简介:" + detail + "</br>" +
                "联系方式:" + method + "</br>");
        model.addAttribute("back","报名成功，请等待通知面试。");
        return "sighup/index";
    }
    @RequestMapping(value = {"","index","index.html","index.php"},method = RequestMethod.GET)
    public String index(){
        return "sighup/index";
    }


}
