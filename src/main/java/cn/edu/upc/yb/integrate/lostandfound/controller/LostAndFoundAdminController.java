package cn.edu.upc.yb.integrate.lostandfound.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.lostandfound.config.LostAndFoundConfig;
import cn.edu.upc.yb.integrate.lostandfound.dao.LostAndFoundOfficialDao;
import cn.edu.upc.yb.integrate.lostandfound.dao.LostAndFoundUserDao;
import cn.edu.upc.yb.integrate.lostandfound.dto.JsonMes;
import cn.edu.upc.yb.integrate.lostandfound.model.LostAndFoundOfficial;
import cn.edu.upc.yb.integrate.lostandfound.model.LostAndFoundUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by 17797 on 2017/5/30.
 */
@RestController
@RequestMapping("/lostandfound")
public class LostAndFoundAdminController {

    @Autowired
    private LostAndFoundOfficialDao officialDao;

    @Autowired
    private HttpSession session = null;

    @Autowired
    private LostAndFoundUserDao userDao;

    @Autowired
    private LostAndFoundConfig config;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CommonAdminService commonAdminService;

    /**
     * 管理员添加数据库
     *
     * @param title
     * @param detail
     */
    @RequestMapping(value = "/official", method = RequestMethod.POST)
    public Object offcialAddData(String title, String detail) {
        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(0,"没有登陆");
        if (commonAdminService.isCommonAdmin() == false)
            return new JsonMes(-1, "您没有权限操作");
        Date now = new Date();
        LostAndFoundOfficial official = new LostAndFoundOfficial(title, detail, now.toString());
        officialDao.save(official);
        return "添加成功";
    }

    /**
     * 删除某条数据
     *
     * @param id
     * @return
     */

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Object delete(int id, int type) {
        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(0,"没有登陆");
        if (commonAdminService.isCommonAdmin() == false)
            return new JsonMes(-1, "您没有权限操作");
        if(type==0) {
            LostAndFoundOfficial official = officialDao.findOne(id);
            official.setIsdelet(true);
            officialDao.save(official);
        }else {
            LostAndFoundUser user = userDao.findOne(id);
            System.out.println(user.isdelet());
            user.setIsdelet(true);
            userDao.save(user);
        }
        return "删除成功";
    }

    /**
     * 改变状态
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/changestatus",method = RequestMethod.POST)
    public Object changestatus(int id) {
        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(0,"没有登陆");
        if (commonAdminService.isCommonAdmin() == false)
            return new JsonMes(-1, "您没有权限操作");
        LostAndFoundOfficial official = officialDao.findOne(id);
        if (official.getStatus() == 0) {
            official.setStatus(1);
        } else {
            official.setStatus(0);
        }
        officialDao.save(official);
        return "改变成功";
    }

}
