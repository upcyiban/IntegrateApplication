package cn.edu.upc.yb.integrate.calendar;

import cn.edu.upc.yb.integrate.IntegrateApplication;
import cn.edu.upc.yb.integrate.calendar.dao.SchoolEventDao;
import cn.edu.upc.yb.integrate.calendar.model.SchoolEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by Jaxlying on 2016/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrateApplication.class)
@WebAppConfiguration
public class CalendarTest {

    @Autowired
    SchoolEventDao schoolEventDao;

    @Test
    public void testdate() {
        Date date = new Date();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println(localDate.toString());
        System.out.println(date.toString());
        System.out.println(localTime.toString());
    }


    @Test
    public void creatEven() {
        SchoolEvent schoolEvent = new SchoolEvent("2016-07-09", "2016-07-09", "11:03:20", "22:12:20", "易班放电影", "放电影");
        System.out.println(schoolEventDao.save(schoolEvent));
    }

    @Test
    public void updateEvent() {
        SchoolEvent schoolEvent = new SchoolEvent("2016-07-09", "2016-07-09", "11:03:20", "22:12:20", "易班放电影", "放电影");
        schoolEvent.setId(3);
        schoolEventDao.save(schoolEvent);
    }

    @Test
    public void eventSeeder() {
        for (int i = 0; i < 9; i++){
            SchoolEvent schoolEvent = new SchoolEvent( "11:03:20", "22:12:20","2016-07-0" + i, "2016-07-0" + i, "易班放电影" + i, "放电影" + i);
            System.out.println(schoolEventDao.save(schoolEvent));
        }
    }


}
