package cn.edu.upc.yb.integrate.calendar;

import cn.edu.upc.yb.integrate.IntegrateApplication;
import cn.edu.upc.yb.integrate.calendar.config.CalendarConfig;
import cn.edu.upc.yb.integrate.calendar.dao.SchoolEventDao;
import cn.edu.upc.yb.integrate.calendar.model.SchoolEvent;
import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import org.junit.Assert;
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

    @Autowired
    YibanOAuth yibanOAuth;

    @Autowired
    CalendarConfig calendarConfig;


    @Test
    public void testoauth(){
        String ve = "3f0e350a8c295b4c7d3cbecc16141f519fc2809dea96863c65217d1cdb572a71c37b176c577fdd7b3797d983dd20bbca25d96e94c939c56cf02410b15b86a77e6228d5b96d23bb2dda46b243e250a70a1e22e017a23b7cc1178c955d9f1944f6dcb5a0a0f4788daf711cc3210f1209c0d1b926e20fa550ed8f863028093cabc2282a79a67c726521bd2a84fc780899f4a5a66ed94a437a1a8f8648a6522e3ef2c1ff00f600e5b205ef6bc5bfbe44aba9162ddf81f8acd673c7826d90823787b68e8a9d36fd0e33103fd74514b107728bae3daed4f57b91399d3ddb6e08a75a0a";
        yibanOAuth.dealYibanOauth(ve,calendarConfig.appid,calendarConfig.appkey);


    }


}
