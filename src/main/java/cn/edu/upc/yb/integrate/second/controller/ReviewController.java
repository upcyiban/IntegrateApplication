package cn.edu.upc.yb.integrate.second.controller;

import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.second.dto.JsonMes;
import cn.edu.upc.yb.integrate.second.model.Review;
import cn.edu.upc.yb.integrate.second.model.OurUser;
import cn.edu.upc.yb.integrate.second.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@RestController
@RequestMapping("second/review")
public class ReviewController {

    @Autowired
    private ReviewRepository revisionRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping("/getreview")
    public Object getReview(int publishid){
        return revisionRepository.findByPublishid(publishid);
    }

    @RequestMapping("/doreview")
    public Object doReview(int publishid, @RequestParam(value = "reviweid", defaultValue = "0")int reviewid, String detail){
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo)httpSession.getAttribute("user");
        if(yibanBasicUserInfo==null) return new JsonMes(-1,"你还没有登陆");
        OurUser user = (OurUser)httpSession.getAttribute("ouruser");
        Review review = new Review(publishid,reviewid,detail,user.getUserid(),user.getUsername(),user.getYbhead());
        revisionRepository.save(review);
        return new JsonMes(1,"评论成功");
    }
}
