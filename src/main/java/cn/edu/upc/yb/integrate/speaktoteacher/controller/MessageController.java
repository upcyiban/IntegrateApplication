package cn.edu.upc.yb.integrate.speaktoteacher.controller;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.speaktoteacher.model.Message;
import cn.edu.upc.yb.integrate.speaktoteacher.repository.MessageRepository;
import cn.edu.upc.yb.integrate.speaktoteacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by wanghaojun on 2017/3/29.
 */
@RestController
@RequestMapping("/speaktoteacher")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value = "/getteacher",method = RequestMethod.GET)
    public Object showTeacher(int yibanId){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        return teacherRepository.findFirstByYibanId(yibanId);
    }

    @RequestMapping(value ="/createmessage" ,method = RequestMethod.GET)
    public Object createMessage(String content, int teacherYBId){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanId = user.visit_user.userid;
        Message message =new Message();
        message.setContent(content);
        message.setTeacherId(teacherYBId);//存老师的易班id
        message.setYibanId(yibanId);//getybid
        Date date=new Date();
        message.setCreateTime(date);
        message.setReply("未回复");
        messageRepository.save(message);
        return new JsonMes(1,"留言成功");
    }

    @RequestMapping(value = "/showmessage",method = RequestMethod.GET)
    public Object showMessage(){
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo user=(YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanId = user.visit_user.userid;
        return messageRepository.findByYibanId(yibanId);
    }

}
