package cn.edu.upc.yb.integrate.speaktoteacher.controller;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
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

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Object showTeacher(int id){

        return teacherRepository.findOne(id);
    }

    @RequestMapping(value ="/createmessage" ,method = RequestMethod.GET)
    public Object createMessage(String content, int teacherId){
        Message message =new Message();
        message.setContent(content);
        message.setTeacherId(teacherId);
        message.setYibanId(1);//getybid
        Date date=new Date();
        message.setCreateTime(date);
        message.setReply("未回复");
        messageRepository.save(message);
        return new JsonMes(1,"留言成功");
    }

    @RequestMapping(value = "/showmessage",method = RequestMethod.GET)
    public Object showMessage(){
      int yibanId=1;
      return messageRepository.findByYibanId(yibanId);
    }

}
