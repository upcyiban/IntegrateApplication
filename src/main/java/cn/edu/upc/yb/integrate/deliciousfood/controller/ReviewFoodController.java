package cn.edu.upc.yb.integrate.deliciousfood.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.model.YBUser;
import cn.edu.upc.yb.integrate.common.service.AppAdminService;
import cn.edu.upc.yb.integrate.deliciousfood.dao.ReviewFoodDao;
import cn.edu.upc.yb.integrate.deliciousfood.dao.VarietyOfDishesDao;
import cn.edu.upc.yb.integrate.deliciousfood.dto.YBUserDto;
import cn.edu.upc.yb.integrate.deliciousfood.model.ReviewFood;
import cn.edu.upc.yb.integrate.deliciousfood.model.VarietyOfDishes;
import cn.edu.upc.yb.integrate.deliciousfood.service.YBUserService;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    @Autowired
    private VarietyOfDishesDao varietyOfDishesDao;

    @RequestMapping("/getreview")
    public Object getReview(int id) {
        return reviewDao.findByDishesIdOrderByUpdateTime(id);
    }

    @RequestMapping("/doreview")
    public Object doReview(int dishesid, String detials,int num) {
            YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo) httpSession.getAttribute("user");
            System.out.println("useid is:" + yibanBasicUserInfo.visit_user.userid);
            if (yibanBasicUserInfo == null)
                return new ErrorReporter(-1, "没有登陆");
            ReviewFood review = new ReviewFood(dishesid, yibanBasicUserInfo.visit_user.userid, yibanBasicUserInfo.visit_user.username, detials, yibanBasicUserInfo.visit_user.userhead,num);
            reviewDao.save(review);
            return new JsonMes(1, "评论成功");
    }
    @RequestMapping("/score")
    public Object recreate(int id,double num){
        YibanBasicUserInfo yibanBasicUserInfo =(YibanBasicUserInfo) httpSession.getAttribute("user");
        if (yibanBasicUserInfo == null)
            return new ErrorReporter(-1, "没有登陆");
        VarietyOfDishes varietyOfDishes =varietyOfDishesDao.findOne(id);
        if (num<0||num>10)
            return new JsonMes(-1,"无效评价");
        else
            varietyOfDishes.setNum(num);
        varietyOfDishesDao.save(varietyOfDishes);
        return new JsonMes(1,"创建成功");
    }
    @RequestMapping("/getuser")
    public Object getUser() throws IOException {
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo) httpSession.getAttribute("user");
        String access_token = yibanBasicUserInfo.visit_oauth.access_token;
        System.out.println(access_token);
        int ybid = yibanBasicUserInfo.visit_user.userid;
        YBUserService ybUserService = new YBUserService();
        ybUserService.getMessage(access_token,ybid);
        System.out.println( ybUserService.getMessage(access_token,ybid));
        String name = yibanBasicUserInfo.visit_user.username;
        String head = yibanBasicUserInfo.visit_user.userhead;
        System.out.println("name:"+name);
        System.out.println("head:"+head);
        YBUserDto ybUserDto = new YBUserDto(name,head);
        return ybUserDto;
    }
}
