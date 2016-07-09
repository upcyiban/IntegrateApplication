package cn.edu.upc.yb.integrate.calendar.controller;

import cn.edu.upc.yb.integrate.calendar.dao.SchoolEventDao;
import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.calendar.model.SchoolEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jaxlying on 2016/7/9.
 */
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private SchoolEventDao schoolEventDao;

    @RequestMapping("/create")
    public Object creatEven(String starttime, String endtime, String startdate, String enddate, String detail, String title) {
        SchoolEvent schoolEvent = new SchoolEvent(starttime, endtime, startdate, enddate, detail, title);
        schoolEventDao.save(schoolEvent);
        return new JsonMes(1,"创建成功");
    }

    @RequestMapping("/update")
    public Object updateEven(int id,String starttime, String endtime, String startdate, String enddate, String detail, String title){
        SchoolEvent schoolEvent = new SchoolEvent(starttime, endtime, startdate, enddate, detail, title);
        schoolEvent.setId(id);
        schoolEventDao.save(schoolEvent);
        return new JsonMes(1,"更新成功");
    }

    @RequestMapping("/delete")
    public Object deleteEven(int id){
        SchoolEvent schoolEvent =schoolEventDao.findOne(id);
        schoolEvent.setIsdelete(true);
        schoolEventDao.save(schoolEvent);
        return new JsonMes(1,"删除成功");
    }

    @RequestMapping("/showevent")
    public Object showEvent(String startdate){
        return schoolEventDao.findByStartdateAndIsdelete(startdate,false);
    }
}
