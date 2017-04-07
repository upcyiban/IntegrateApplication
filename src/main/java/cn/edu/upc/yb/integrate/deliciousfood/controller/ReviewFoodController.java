package cn.edu.upc.yb.integrate.deliciousfood.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.service.AppAdminService;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.deliciousfood.dao.ReviewFoodDao;
import cn.edu.upc.yb.integrate.deliciousfood.model.ReviewFood;
import cn.edu.upc.yb.integrate.deliciousfood.model.User;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.SybaseAnywhereMaxValueIncrementer;
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
    public Object getReview(@RequestParam(value = "0")int id){
        return reviewDao.findByDishesIdOrderByUpdateTime(id);
    }

    @RequestMapping("/doreview")
    public Object doReview(int dishesid,String detials){


        User user = (User)httpSession.getAttribute("user");
        if (user==null)
            return new ErrorReporter(-1,"没有登陆");
        System.out.println("useid is:" + user.getId());
        ReviewFood review = new ReviewFood( dishesid, user.getId(),user.getUsername(),detials,user.getYbhead());
        reviewDao.save(review);
        return new JsonMes(1,"评论成功");
    }
}
