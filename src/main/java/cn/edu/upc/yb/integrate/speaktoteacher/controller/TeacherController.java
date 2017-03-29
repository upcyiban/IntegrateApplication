package cn.edu.upc.yb.integrate.speaktoteacher.controller;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.speaktoteacher.config.SttConfig;
import cn.edu.upc.yb.integrate.speaktoteacher.model.Message;
import cn.edu.upc.yb.integrate.speaktoteacher.model.Teacher;
import cn.edu.upc.yb.integrate.speaktoteacher.repository.MessageRepository;
import cn.edu.upc.yb.integrate.speaktoteacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * Created by wanghaojun on 2017/3/29.
 */
@RestController
@RequestMapping("/speaktoteacher")
public class TeacherController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private SttConfig sttConfig;

    @RequestMapping(value = "/listmessage",method = RequestMethod.GET)
    public Object listmessage(int teacherId)
    {
        return messageRepository.findByTeacherId(teacherId);
    }

    @RequestMapping(value = "/reply",method = RequestMethod.GET)
    public Object reply(int id,String reply){

        Message message = new Message();
        message=messageRepository.findOne(id);
        message.setReply(reply);
        message.setReplyTime(new Date());
        messageRepository.save(message);
        return new JsonMes(1,"回复成功");
    }
    @RequestMapping(value = "/createqrcode",method = RequestMethod.GET)
    public Object createqrcode(int id){

        Teacher teacher = new Teacher();
        teacher=teacherRepository.findOne(id);
        String qrcode;
        if (teacher.getQRcode().isEmpty()){
            qrcode ="http://qr.topscan.com/api.php?text=" + sttConfig.fronturl + "/speaktoteacher?id=" + id;
            teacher.setQRcode(qrcode);
            teacherRepository.save(teacher);
        }
        else {
            qrcode =teacher.getQRcode();
        }
        return new JsonMes(1,qrcode);
    }

    @RequestMapping(value = "/updateprofie",method = RequestMethod.GET)
    public Object updateProfile(int id,String profile){
        Teacher teacher = new Teacher();
        teacher=teacherRepository.findOne(id);
        teacher.setProfile(profile);
        teacherRepository.save(teacher);
        return new JsonMes(1,"修改个人简介成功");
    }


    @RequestMapping(value = "/updatemotto",method = RequestMethod.GET)
    public Object updateMotto(int id, String motto){
        Teacher teacher = new Teacher();
        teacher=teacherRepository.findOne(id);
        teacher.setMotto(motto);
        teacherRepository.save(teacher);
        return new JsonMes(1,"修改座右铭成功");
    }

    @RequestMapping(value = "/updatephonenumber",method = RequestMethod.GET)
    public Object updatePhoneNumber(int id,String phonenumber){
        Teacher teacher = new Teacher();
        teacher=teacherRepository.findOne(id);
        teacher.setPhonenumber(phonenumber);
        teacherRepository.save(teacher);
        return new JsonMes(1,"修改电话号码成功");

    }

    @RequestMapping(value = "/updateemail",method = RequestMethod.GET)
    public Object updateEmail(int id,String email){
        Teacher teacher = new Teacher();
        teacher=teacherRepository.findOne(id);
        teacher.setEmail(email);
        teacherRepository.save(teacher);
        return new JsonMes(1,"修改电子邮件成功");
    }






}
