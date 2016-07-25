package cn.edu.upc.yb.integrate.lostandfound.controller;


import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.lostandfound.model.User;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.lostandfound.model.Official;
import cn.edu.upc.yb.integrate.common.util.LinkPage;
import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.lostandfound.dao.OfficialDao;
import cn.edu.upc.yb.integrate.lostandfound.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by wanghaojun on 2016/7/12.
 */
@RestController
@RequestMapping("/lostandfound")
public class LostAndFoundIndexController {

    @Autowired
    private OfficialDao officialDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private CommonAdminService commonAdminService;


    @RequestMapping("/")
    public Object showIndex(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
      if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");

        Iterable<Official> officials = officialDao.findByIsdeletNotOrderByDateDesc(true);
        return officials;
    }

    @RequestMapping(value = "/official", method = RequestMethod.POST)
    public Object offcialAddData(String title, String detail) {
      if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        Date now = new Date();
        Official official = new Official(title, detail, now.toString());
        officialDao.save(official);

        return new JsonMes(1, "创建成功");
    }
    @RequestMapping("/delet")
    public Object delet(int id, int type) {
      if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        if(type==0) {
            Official official = officialDao.findOne(id);
            official.setIsdelet(true);
            officialDao.save(official);
        }else {
            User user = userDao.findOne(id);
            System.out.println(user.isdelet());
            user.setIsdelet(true);
            userDao.save(user);

        }
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/changestatus")
    public Object changestatus(int id) {
       if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        Official official = officialDao.findOne(id);
        if (official.getStatus() == 0) {
            official.setStatus(1);
        } else {
            official.setStatus(0);
        }
        officialDao.save(official);
        return new JsonMes(1, "更新成功");
    }
    @RequestMapping("/detail")
    public Object showDetail(int id,int type, Model model) {
        String detail = null;
        if(type == 0) {
            detail = officialDao.findOne(id).getDetail();
        }else {
            detail = userDao.findOne(id).getDetail();
        }
        return detail;
    }

}
