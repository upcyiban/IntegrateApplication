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
        String ve = "261d2c3a69085e38b04ba6f63d3073a6bfc4def7a61593c4d8c0784588603204f196723b3091a9806a37f832930252b3346cd73ca2eb91737b92dc56eb21119f140ca30d21c9425f7dc5302d7c241e9640825cac11cd4278ce2dc70e9c6d7622b4d0cad2e5e56d5aa74331d5ac2626aadd9b433b40286b7ddf5d118c9107e98f415452443fda5ebe91f506f60eab6c960b8c8590c85122ecd384f62cd6d5e436f09df4e36eb7a0cdb56e2eb93bc5f8e5c7cc6a15e88deb4ba71f5d4dac005bccca3e83f61d27efa40c9f3dba685020559c21b561739973935d6662b7b88c1f9379";
        yibanOAuth.dealYibanOauth(ve,calendarConfig.appid,calendarConfig.appkey);


    }


}
