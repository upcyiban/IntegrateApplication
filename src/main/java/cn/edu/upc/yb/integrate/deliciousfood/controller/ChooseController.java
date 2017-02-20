package cn.edu.upc.yb.integrate.deliciousfood.controller;

import cn.edu.upc.yb.integrate.deliciousfood.dao.VarietyOfDishesDao;
import cn.edu.upc.yb.integrate.deliciousfood.model.VarietyOfDishes;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * Created by 陈子枫 on 2017/2/6.
 */
@RestController
@RequestMapping("/choose")
public class ChooseController {

    @Autowired
   private VarietyOfDishesDao varietyOfDishesDao;

//
//    @RequestMapping("/byname")
//    public Object byName(String name) {
//        return varietyOfDishesDao.findByName(name);
//    }
//
//    @RequestMapping("/byregion")
//    public Object byRegion(String region) {
//        return varietyOfDishesDao.findByRegion(region);
//    }
//
//    @RequestMapping("/bykind")
//    public Object byKind(String kind) {
//        return varietyOfDishesDao.findByKind(kind);
//    }
//
//    @RequestMapping("/bycook")
//    public Object byCook(String cook) {
//        return varietyOfDishesDao.findByCook(cook);
//    }
//
//    @RequestMapping("/byrestaurant")
//    public Object byRestaurant(String restaurant) {
//        return varietyOfDishesDao.findByRestaurant(restaurant);
//    }

    @RequestMapping("/find")
    public Object findThing(String name, String region, String kind, String cook, String restaurant, String price) {
        if (null == name) {
            if (null == region) {
                if (null == kind) {
                    if (null == cook) {
                        if (null == restaurant) {
                            if (null == price)
                                return varietyOfDishesDao.findAll();
                            else

                                return varietyOfDishesDao.findByPrice(price);
                        } else {
                            if (null == price)
                                return varietyOfDishesDao.findByRestaurant(restaurant);
                            else
                                return varietyOfDishesDao.findByRestaurantAndPrice(restaurant, price);
                        }
                    } else {
                        if (null == restaurant) {
                            if (null == price)
                                return varietyOfDishesDao.findByCook(cook);
                            else
                                return varietyOfDishesDao.findByCookAndPrice(cook,price);
                        } else {
                            if (null == price)
                                return varietyOfDishesDao.findByCookAndRestaurant(cook,restaurant);
                            else
                                return varietyOfDishesDao.findByCookAndRestaurantAndPrice(cook,restaurant, price);
                        }
                    }
                } else {                //kind的大分类，最后一个包含四个
                    if (null == cook) {
                        if (null == restaurant) {
                            if (null == price)
                                return varietyOfDishesDao.findByKind(kind);
                            else
                                return varietyOfDishesDao.findByKindAndPrice(kind,price);
                        } else {
                            if (null == price)
                                return varietyOfDishesDao.findByKindAndRestaurant(kind,restaurant);
                            else
                                return varietyOfDishesDao.findByKindAndRestaurantAndPrice(kind,restaurant, price);
                        }
                    } else {
                        if (null == restaurant) {
                            if (null == price)
                                return varietyOfDishesDao.findByKindAndCook(kind,cook);
                            else
                                return varietyOfDishesDao.findByKindAndCookAndPrice(kind,cook,price);
                        } else {
                            if (null == price)
                                return varietyOfDishesDao.findByKindAndCookAndRestaurant(kind,cook,restaurant);
                            else
                                return varietyOfDishesDao.findByKindAndCookAndRestaurantAndPrice(kind,cook,restaurant, price);
                        }
                    }
                }
            } else {
                if (null == kind) {
                    if (null == cook) {
                        if (null == restaurant) {
                            if (null == price)
                                return varietyOfDishesDao.findByRegion(region);
                            else
                                return varietyOfDishesDao.findByRegionAndPrice(region,price);
                        } else {
                            if (null == price)
                                return varietyOfDishesDao.findByRegionAndRestaurant(region,restaurant);
                            else
                                return varietyOfDishesDao.findByRegionAndRestaurantAndPrice(region, restaurant, price);
                        }
                    } else {
                        if (null == restaurant) {
                            if (null == price)
                                return varietyOfDishesDao.findByRegionAndCook(region,cook);
                            else
                                return varietyOfDishesDao.findByRegionAndCookAndPrice(region,cook,price);
                        } else {
                            if (null == price)
                                return varietyOfDishesDao.findByRegionAndCookAndRestaurant(region,cook,restaurant);
                            else
                                return varietyOfDishesDao.findByRegionAndCookAndRestaurantAndPrice(region,cook,restaurant, price);
                        }
                    }
                } else {                //kind的大分类，最后一个包含四个
                    if (null == cook) {
                        if (null == restaurant) {
                            if (null == price)
                                return varietyOfDishesDao.findByRegionAndKind(region,kind);
                            else
                                return varietyOfDishesDao.findByRegionAndKindAndPrice(region,kind,price);
                        } else {
                            if (null == price)
                                return varietyOfDishesDao.findByRegionAndKindAndRestaurant(region,kind,restaurant);
                            else
                                return varietyOfDishesDao.findByRegionAndKindAndRestaurantAndPrice(region,kind,restaurant, price);
                        }
                    } else {
                        if (null == restaurant) {
                            if (null == price)
                                return varietyOfDishesDao.findByRegionAndKindAndCook(region,kind,cook);
                            else
                                return varietyOfDishesDao.findByRegionAndKindAndCookAndPrice(region,kind,cook,price);
                        } else {
                            if (null == price)
                                return varietyOfDishesDao.findByRegionAndKindAndCookAndRestaurant(region,kind,cook,restaurant);
                            else
                                return varietyOfDishesDao.findByRegionAndKindAndCookAndRestaurantAndPrice(region,kind,cook,restaurant, price);
                        }
                    }
                }
            }
        } else {
            return varietyOfDishesDao.findByName(name);
        }
    }
}
