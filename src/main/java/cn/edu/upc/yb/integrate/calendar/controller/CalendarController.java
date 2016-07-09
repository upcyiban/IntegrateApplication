package cn.edu.upc.yb.integrate.calendar.controller;

import cn.edu.upc.yb.integrate.calendar.dao.SchoolCalendarDao;
import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.calendar.model.SchoolCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private SchoolCalendarDao schoolCalendarDao;

    @RequestMapping("/create")
    public Object creatCalendar(String schoolschedule, String begindate, String enddate) {
        SchoolCalendar schoolCalendar = new SchoolCalendar(schoolschedule, begindate, enddate);
        schoolCalendarDao.save(schoolCalendar);
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping("/update")
    public Object updateCalendar(int id, String schoolschedule, String begindate, String enddate) {
        SchoolCalendar schoolCalendar = schoolCalendarDao.findOne(id);
        schoolCalendar.updata(schoolschedule, begindate, enddate);
        schoolCalendarDao.save(schoolCalendar);
        return new JsonMes(1, "更新成功");
    }

    @RequestMapping("/delete")
    public Object deleteCalendar(int id) {
        SchoolCalendar schoolCalendar = schoolCalendarDao.findOne(id);
        schoolCalendar.delete();
        schoolCalendarDao.save(schoolCalendar);
        return new JsonMes(1, "删除成功");
    }

    @RequestMapping("/showcalendar")
    public Object showCalendar(String schoolschedule) {
        return schoolCalendarDao.findBySchoolscheduleAndIsdelete(schoolschedule, false);
    }

    /**
     * 管理员显示全部
     */
    @RequestMapping("/showall")
    public Object showAll(){
        return schoolCalendarDao.findAll();
    }

}
