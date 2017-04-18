package cn.edu.upc.yb.integrate.deliciousfood.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.service.AppAdminService;
import cn.edu.upc.yb.integrate.deliciousfood.dao.ReviewFoodDao;
import cn.edu.upc.yb.integrate.deliciousfood.model.ReviewFood;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by 陈子枫 on 2017/3/23.
 */
@RequestMapping("deliciousfood/review")
@RestController
public class ReviewFoodController {

    @Autowired
    private ReviewFoodDao reviewDao;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private AppAdminService appAdminService;

    @RequestMapping("/getreview")
    public Object getReview(int id){
        return reviewDao.findByDishesIdOrderByUpdateTime(id);
    }

    @RequestMapping("/doreview")
    public Object doReview(int dishesid,String detials){
        YibanBasicUserInfo yibanBasicUserInfo =(YibanBasicUserInfo) httpSession.getAttribute("user");
        if (yibanBasicUserInfo.visit_user ==null)
            return new ErrorReporter(-1,"没有登陆");
        System.out.println("useid is:" + yibanBasicUserInfo.visit_user.userid);
        ReviewFood review = new ReviewFood( dishesid, yibanBasicUserInfo.visit_user.userid,yibanBasicUserInfo.visit_user.username,detials,yibanBasicUserInfo.visit_user.userhead);
        reviewDao.save(review);
        return new JsonMes(1,"评论成功");
    }

    @RequestMapping("/test")
    public Object test(){
        for(int i =0;i<10;i++){
            YibanBasicUserInfo yibanBasicUserInfo =(YibanBasicUserInfo) httpSession.getAttribute("user");
            ReviewFood reviewFood = new ReviewFood(i,5830649,"EZ","这道菜还不错","images/face.jpg");
            reviewDao.save(reviewFood);
        }

        return reviewDao.findAll();
    }
}
