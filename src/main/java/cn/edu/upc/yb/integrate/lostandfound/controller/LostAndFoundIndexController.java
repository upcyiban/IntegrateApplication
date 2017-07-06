package cn.edu.upc.yb.integrate.lostandfound.controller;

import cn.edu.upc.yb.integrate.lostandfound.dao.LostAndFoundOfficialDao;
import cn.edu.upc.yb.integrate.lostandfound.dao.LostAndFoundUserDao;
import cn.edu.upc.yb.integrate.lostandfound.dto.JsonMes;
import cn.edu.upc.yb.integrate.lostandfound.model.LostAndFoundOfficial;
import cn.edu.upc.yb.integrate.lostandfound.model.LostAndFoundUser;
import org.codehaus.groovy.tools.ErrorReporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by 17797 on 2017/5/30.
 */
@RestController
@RequestMapping("/lostandfound")
public class LostAndFoundIndexController {

    @Autowired
    private LostAndFoundOfficialDao officialDao;

    @Autowired
    private LostAndFoundUserDao userDao;

    @RequestMapping(value = "/")
    public Object showIndex() {
        return userDao.findByIsdeletNotOrderByDateDesc(false);
    }

    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public Object showDetail(int id,int type) {
        if(type == 0) {
            return  officialDao.findOne(id).getDetail();
        }else {
            return  userDao.findOne(id).getDetail();
        }
    }

}