package cn.edu.upc.yb.integrate.competiton.controller;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.competiton.model.Medal;
import cn.edu.upc.yb.integrate.competiton.repository.MedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by wanghaojun on 2017/4/9.
 */
@RestController
@RequestMapping("/competition")
public class CompetionController {

    @Autowired
    MedalRepository medalRepository;

    @Autowired
    HttpSession httpSession;

    @RequestMapping("/getmedal")
    public Object getMedalNumber(){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanid=user.visit_user.userid;
        return medalRepository.findFirstByYibanId(yibanid);
    }

    @RequestMapping("/setmedal")
    public Object setMedalNumber(){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanid=user.visit_user.userid;
        Medal medal=medalRepository.findFirstByYibanId(yibanid);
        if(medal==null){
            String yibanName=user.visit_user.username;
            int number=1;
            medal=new Medal(yibanid,yibanName,number);
            medalRepository.save(medal);
        }
        else {
            medal.setNumber(medal.getNumber()+1);
            medalRepository.save(medal);
        }
        return new JsonMes(1,"success");
    }
}
