package cn.edu.upc.yb.integrate.calendar.controller;

import cn.edu.upc.yb.integrate.calendar.dao.SchoolEventDao;
import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.calendar.model.SchoolEvent;
import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Jaxlying on 2016/7/9.
 */
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private SchoolEventDao schoolEventDao;

    @Autowired
    private CommonAdminService commonAdminService;

    @RequestMapping("/create")
    public Object creatEven(String starttime, String endtime, String startdate, String enddate, String detail, String title) {
        if(commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1,"您没有权限操作");
        SchoolEvent schoolEvent = new SchoolEvent(starttime, endtime, startdate, enddate, detail, title);
        schoolEventDao.save(schoolEvent);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping("/update")
    public Object updateEven(@RequestParam(value = "id",defaultValue = "0")int id, String starttime, String endtime, String startdate, String enddate, String detail, String title) {
        if(commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1,"您没有权限操作");
        SchoolEvent schoolEvent = schoolEventDao.findOne(id);
        schoolEvent.updata(starttime, endtime, startdate, enddate, detail, title);
        schoolEventDao.save(schoolEvent);
        return new JsonMes(1, "更新成功");
    }

    @RequestMapping("/delete")
    public Object deleteEven(@RequestParam(value = "id",defaultValue = "0")int id) {
        if(commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1,"您没有权限操作");
        SchoolEvent schoolEvent = schoolEventDao.findOne(id);
        schoolEvent.delete();
        schoolEventDao.save(schoolEvent);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/showevent")
    public Object showEvent(String startdate) {
        if(commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1,"您没有权限操作");
        return schoolEventDao.findByStartdateAndIsdelete(startdate, false);
    }
    /**
     * 管理员显示全部
     */

    @Autowired
    HttpSession httpSession;
    @RequestMapping("/showall")
    public Object showAll(){
        if(commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1,"您没有权限操作");
        return schoolEventDao.findByIsdeleteOrderByIdDesc(false);
    }
}
