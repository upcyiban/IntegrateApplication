package cn.edu.upc.yb.integrate.calendar;

import cn.edu.upc.yb.integrate.IntegrateApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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

    @Test
    public void testdate(){
        Date date = new Date();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println(localDate.toString());
        System.out.println(date.toString());
        System.out.println(localTime.toString());
    }
}
