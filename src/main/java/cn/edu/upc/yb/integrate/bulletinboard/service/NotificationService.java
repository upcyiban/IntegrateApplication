package cn.edu.upc.yb.integrate.bulletinboard.service;

import cn.edu.upc.yb.integrate.bulletinboard.dao.NotificationDao;
import cn.edu.upc.yb.integrate.bulletinboard.model.Notification;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by skyADMIN on 16/7/11.
 */
@Service
public class NotificationService {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CommonAdminService commonAdminService;

    @Autowired
    private NotificationDao notificationDao;

    public Object postNew(String title, String message, String tag){
        YibanBasicUserInfo user = (YibanBasicUserInfo) httpSession.getAttribute("user");
        if (!commonAdminService.isCommonAdmin()){
            return new ErrorReporter(-1,"no-access");
        }
        Notification notification = new Notification(user.visit_user.userid, title, message, tag);
        return notificationDao.save(notification);
    }

}
