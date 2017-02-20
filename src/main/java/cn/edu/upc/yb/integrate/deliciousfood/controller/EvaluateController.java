package cn.edu.upc.yb.integrate.deliciousfood.controller;

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
    VarietyOfDishesDao varietyOfDishesDao;

    @RequestMapping("/create")
    public Object create(String name, String region, String kind, String cook, String restaurant, String price, String imsl){
        VarietyOfDishes varietyOfDishes = new VarietyOfDishes(name,region,kind,cook,restaurant,price,imsl);
        varietyOfDishesDao.save(varietyOfDishes);
        return new JsonMes(1,"创建成功");
    }

    @RequestMapping("/recreate")
    public Object recreate(int id,double num){
        VarietyOfDishes varietyOfDishes =varietyOfDishesDao.findOne(id);
        if (num<0||num>10)
            return new JsonMes(-1,"无效评价");
        else
        varietyOfDishes.setNum(num);
        return new JsonMes(1,"创建成功");
    }

    @RequestMapping("/update")
    public Object update(int id,String price){
        VarietyOfDishes varietyOfDishes =  varietyOfDishesDao.findOne(id);
        varietyOfDishes.setPrice(price);
        return new JsonMes(1,"更改成功" );
    }


}
