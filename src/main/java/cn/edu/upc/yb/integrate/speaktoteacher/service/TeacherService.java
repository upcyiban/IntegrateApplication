package cn.edu.upc.yb.integrate.speaktoteacher.service;

import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.speaktoteacher.model.Teacher;
import cn.edu.upc.yb.integrate.speaktoteacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

/**
 * Created by wanghaojun on 2017/3/30.
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private HttpSession httpSession;



    public boolean isTeacher(int id){
        if (httpSession.getAttribute("user")== null){
            return false;
        }
        YibanBasicUserInfo user = (YibanBasicUserInfo)httpSession.getAttribute("user");
        int yibanid=user.visit_user.userid;
        Teacher teacher=teacherRepository.findOne(id);
        if(yibanid==teacher.getYibanId()){
            return true;
        }
        else return false;


    }

}
