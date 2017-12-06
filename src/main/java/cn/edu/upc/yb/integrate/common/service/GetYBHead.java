package cn.edu.upc.yb.integrate.common.service;

import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.model.YBUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import javax.servlet.http.HttpSession;

/**
 * Created by chenzifeng on 2017/4/6.
 */
@Service
public class GetYBHead {

    @Autowired
    HttpSession httpSession;


    public String getHead() {
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo) httpSession.getAttribute("yibanBasicUserInfo");
        return yibanBasicUserInfo.visit_user.userhead;
    }
}
