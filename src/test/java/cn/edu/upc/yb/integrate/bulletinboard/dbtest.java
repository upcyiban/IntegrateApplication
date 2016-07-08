package cn.edu.upc.yb.integrate.bulletinboard;

import cn.edu.upc.yb.integrate.IntegrateApplication;
import cn.edu.upc.yb.integrate.bulletinboard.dao.NotificationDao;
import cn.edu.upc.yb.integrate.bulletinboard.model.Notification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;

/**
 * Created by skyADMIN on 16/7/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrateApplication.class)
@WebAppConfiguration
public class dbtest {

    @Autowired
    private NotificationDao notificationDao;

    @Test
    public void testDB(){
//        LocalDateTime localDateTime = LocalDateTime.now();
//        Notification notification = new Notification(119, "测试", "222222", "w", localDateTime);
//        notificationDao.save(notification);
        Notification notification1 = notificationDao.findFirstByOrderByIdDesc();
        System.out.println(notification1.getMessage());
    }
}
