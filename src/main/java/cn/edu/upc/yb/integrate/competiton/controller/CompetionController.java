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


    @RequestMapping("/craetemedal")
    public Object createMedal(){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanid=user.visit_user.userid;
        Medal medal=medalRepository.findFirstByYibanId(yibanid);
        if(medal==null){
            String yibanName=user.visit_user.username;
            int number=0;
            medal=new Medal(yibanid,yibanName,number);
            medalRepository.save(medal);
            return new JsonMes(1,"success");
        }
        else return new JsonMes(0,"已存在");
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
    @RequestMapping("/finish1")
    public Object finish1(){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanid=user.visit_user.userid;
        Medal medal=medalRepository.findFirstByYibanId(yibanid);
        if (medal.isFinish1()){
            return new JsonMes(0,"defeat");
        }
        else {
            medal.setFinish1(true);
            medalRepository.save(medal);
            return new JsonMes(1,"finish");
        }
    }
    @RequestMapping("/finish2")
    public Object finish2(){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanid=user.visit_user.userid;

        Medal medal=medalRepository.findFirstByYibanId(yibanid);
        if (medal.isFinish2()){
            return new JsonMes(0,"defeat");
        }
        else {
            medal.setFinish2(true);
            medalRepository.save(medal);
            return new JsonMes(2,"finish");
        }
    }
    @RequestMapping("/finish3")
    public Object finish3(){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
         YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanid=user.visit_user.userid;
        Medal medal=medalRepository.findFirstByYibanId(yibanid);
        if (medal.isFinish3()){
            return new JsonMes(0,"defeat");
        }
        else {
            medal.setFinish3(true);
            medalRepository.save(medal);
            return new JsonMes(3,"finish");
        }
    }
    @RequestMapping("/finish4")
    public Object finish4(){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanid=user.visit_user.userid;
        Medal medal=medalRepository.findFirstByYibanId(yibanid);
        if (medal.isFinish4()){
            return new JsonMes(0,"defeat");
        }
        else {
            medal.setFinish4(true);
            medalRepository.save(medal);
            return new JsonMes(4,"finish");
        }
    }
    @RequestMapping("/finish5")
    public Object finish5(){
       if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
       YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanid=user.visit_user.userid;
        Medal medal=medalRepository.findFirstByYibanId(yibanid);
        if (medal.isFinish5()){
            return new JsonMes(0,"defeat");
        }
        else {
            medal.setFinish5(true);
            medalRepository.save(medal);
            return new JsonMes(5,"finish");
        }
    }


}
