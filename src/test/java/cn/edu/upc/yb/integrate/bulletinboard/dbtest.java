package cn.edu.upc.yb.integrate.bulletinboard;

import cn.edu.upc.yb.integrate.IntegrateApplication;
import cn.edu.upc.yb.integrate.bulletinboard.dao.NotificationDao;
import cn.edu.upc.yb.integrate.bulletinboard.model.Notification;
import cn.edu.upc.yb.integrate.bulletinboard.service.NotificationService;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private HttpSession httpSession;

    @Test
    @Transactional
    public void testDB(){
        Notification notification = new Notification(119, "测试233", "222222", "w");
        notificationDao.save(notification);
        Notification notification1 = notificationDao.findFirstByOrderByIdDesc();
        Assert.assertEquals(notification1.getTitle(), "测试233");
    }

    @Test
    @Transactional
    @Rollback
    public void testPostNew(){
        YibanBasicUserInfo user = new YibanBasicUserInfo();
        user.visit_user = new YibanBasicUserInfo().new VisitUser();
        user.visit_user.userid = 5394432;
        httpSession.setAttribute("user", user);
        notificationService.postNew("测试2", "这是一段测试文字111", "default");
        notificationService.deleteOne(1);
    }
}
