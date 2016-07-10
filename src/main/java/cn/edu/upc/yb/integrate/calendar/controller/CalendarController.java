package cn.edu.upc.yb.integrate.calendar.controller;

import cn.edu.upc.yb.integrate.calendar.dao.SchoolCalendarDao;
import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.calendar.model.SchoolCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private SchoolCalendarDao schoolCalendarDao;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/create")
    public Object creatCalendar(String schoolschedule, String begindate, String enddate) {
        if(httpSession.getAttribute("admin")==null) { return new JsonMes(0,"您还没用登陆");}
        SchoolCalendar schoolCalendar = new SchoolCalendar(schoolschedule, begindate, enddate);
        schoolCalendarDao.save(schoolCalendar);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping("/update")
    public Object updateCalendar(@RequestParam(value = "id",defaultValue = "0") int id, String schoolschedule, String begindate, String enddate) {
        if(httpSession.getAttribute("admin")==null) { return new JsonMes(0,"您还没用登陆");}
        SchoolCalendar schoolCalendar = schoolCalendarDao.findOne(id);
        schoolCalendar.updata(schoolschedule, begindate, enddate);
        schoolCalendarDao.save(schoolCalendar);
        return new JsonMes(1, "更新成功");
    }

    @RequestMapping("/delete")
    public Object deleteCalendar(@RequestParam(value = "id",defaultValue = "0") int id) {
        if(httpSession.getAttribute("admin")==null) { return new JsonMes(0,"您还没用登陆");}
        SchoolCalendar schoolCalendar = schoolCalendarDao.findOne(id);
        schoolCalendar.delete();
        schoolCalendarDao.save(schoolCalendar);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/showcalendar")
    public Object showCalendar(String schoolschedule) {
        if(httpSession.getAttribute("admin")==null) { return new JsonMes(0,"您还没用登陆");}
        return schoolCalendarDao.findBySchoolscheduleAndIsdelete(schoolschedule, false);
    }

    /**
     * 管理员显示全部
     */
    @RequestMapping("/showall")
    public Object showAll(){
        if(httpSession.getAttribute("admin")==null) { return new JsonMes(0,"您还没用登陆");}
        return schoolCalendarDao.findByIsdeleteOrderByIdDesc(false);
    }

}
