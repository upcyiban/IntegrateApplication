package cn.edu.upc.yb.integrate.common.controller;

import cn.edu.upc.yb.integrate.common.dao.FeedBackMessageDao;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.model.FeedBackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by skyADMIN on 16/7/17.
 */
@RestController
public class FeedBackController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private FeedBackMessageDao feedBackMessageDao;

    @RequestMapping("/feedback")
    public ErrorReporter makeFeedBack(String message, String appname) {
        if (httpSession.getAttribute("user") == null) {
            return new ErrorReporter(1, "no access");
        }
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo) httpSession.getAttribute("user");
        int yibanid = yibanBasicUserInfo.visit_user.userid;
        FeedBackMessage feedBackMessage = new FeedBackMessage(yibanid, message, appname);
        feedBackMessageDao.save(feedBackMessage);
        return new ErrorReporter(0, "success");
    }

}
