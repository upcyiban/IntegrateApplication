package cn.edu.upc.yb.integrate.deliciousfood.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.deliciousfood.dao.VarietyOfDishesDao;
import cn.edu.upc.yb.integrate.deliciousfood.model.VarietyOfDishes;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 陈子枫 on 2017/2/6.
 * 用于写菜品评价的接口
 */


@RestController
@RequestMapping(value = "/evaluate")
public class EvaluateController {

    @Autowired
    private VarietyOfDishesDao varietyOfDishesDao;

    @Autowired
    private CommonAdminService commonAdminService;

    @RequestMapping("/create")
    public Object create(String name, String region, String kind, String cook, String restaurant, String price, String imsl,String introduce){
       // if(!commonAdminService.isCommonAdmin()) return new ErrorReporter(-1,"您没有权限操作");
        VarietyOfDishes varietyOfDishes = new VarietyOfDishes(name,region,kind,restaurant,price,imsl,introduce);
        System.out.println(name+region+kind+cook+restaurant+price+imsl+introduce);
        varietyOfDishesDao.save(varietyOfDishes);
        return new JsonMes(1,"创建成功");
    }

    @RequestMapping("/recreate")
    public Object recreate(int id,double num){
        if(!commonAdminService.isCommonAdmin()) return new ErrorReporter(-1,"您没有权限操作");
        VarietyOfDishes varietyOfDishes =varietyOfDishesDao.findOne(id);
        if (num<0||num>10)
            return new JsonMes(-1,"无效评价");
        else
        varietyOfDishes.setNum(num);
        varietyOfDishesDao.save(varietyOfDishes);
        return new JsonMes(1,"创建成功");
    }

    @RequestMapping("/update")
    public Object update(int id,String price){
        if(!commonAdminService.isCommonAdmin()) return new ErrorReporter(-1,"您没有权限操作");
        VarietyOfDishes varietyOfDishes =  varietyOfDishesDao.findOne(id);
        varietyOfDishes.setPrice(price);
        varietyOfDishesDao.save(varietyOfDishes);
        return new JsonMes(1,"更改成功" );
    }
    @RequestMapping("/delete")
    public Object delete(int id){
        if(!commonAdminService.isCommonAdmin()) return new ErrorReporter(-1,"您没有权限操作");
        VarietyOfDishes varietyOfDishes = varietyOfDishesDao.findOne(id);
        varietyOfDishesDao.delete(varietyOfDishes);
        return new JsonMes(1,"删除成功");
    }
    @RequestMapping("/test")
    public Object test(){
        int i ;
        for (i=0;i<10;i++){
            VarietyOfDishes varietyOfDishes = new VarietyOfDishes("宫爆鸡丁","鲁菜","酸辣","荟萃2楼","8.5","/img.jpg","好吃");
            varietyOfDishesDao.save(varietyOfDishes);
        }
        return varietyOfDishesDao.findAll();
    }
}
