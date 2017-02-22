package cn.edu.upc.yb.integrate.deliciousfood.dao;

import cn.edu.upc.yb.integrate.deliciousfood.model.VarietyOfDishes;

import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

/**
 * Created by 陈子枫 on 2017/2/6.
 */
public interface VarietyOfDishesDao extends CrudRepository<VarietyOfDishes,Integer>{
    Iterable<VarietyOfDishes> findByName(String name);

    Iterable<VarietyOfDishes> findByRegion(String region);

    Iterable<VarietyOfDishes> findByKind(String kind);

    Iterable<VarietyOfDishes> findByCook(String cook);

    Iterable<VarietyOfDishes> findByRestaurant(String restaurant);

    Iterable<VarietyOfDishes> findByPrice(String price);//有空重写

    Iterable<VarietyOfDishes> findByRestaurantAndPrice(String restaurant,String price);

    Iterable<VarietyOfDishes> findByCookAndPrice(String cook,String price);

    Iterable<VarietyOfDishes> findByCookAndRestaurant(String cook,String restaurant);

    Iterable<VarietyOfDishes> findByCookAndRestaurantAndPrice(String cook,String restaurant,String price);

    Iterable<VarietyOfDishes> findByKindAndPrice(String kind,String price);

    Iterable<VarietyOfDishes> findByKindAndRestaurant(String kind,String restaurant);

    Iterable<VarietyOfDishes> findByKindAndRestaurantAndPrice(String kind,String restaurant,String price);

    Iterable<VarietyOfDishes> findByKindAndCook(String kind,String cook);

    Iterable<VarietyOfDishes> findByKindAndCookAndPrice(String kind,String cook,String price);

    Iterable<VarietyOfDishes> findByKindAndCookAndRestaurant(String kind,String cook,String restaurant)
            ;
    Iterable<VarietyOfDishes> findByKindAndCookAndRestaurantAndPrice(String kind,String cook,String restaurant,String price);

    Iterable<VarietyOfDishes> findByRegionAndPrice(String region,String price);

    Iterable<VarietyOfDishes> findByRegionAndKindAndCookAndRestaurantAndPrice(String region, String kind, String cook, String restaurant, String price);

    Iterable<VarietyOfDishes> findByRegionAndKindAndCookAndRestaurant(String region, String kind, String cook, String restaurant);

    Iterable<VarietyOfDishes> findByRegionAndKindAndCookAndPrice(String region, String kind, String cook, String price);

    Iterable<VarietyOfDishes> findByRegionAndKindAndCook(String region, String kind, String cook);

    Iterable<VarietyOfDishes> findByRegionAndKindAndRestaurantAndPrice(String region, String kind, String restaurant, String price);

    Iterable<VarietyOfDishes> findByRegionAndKindAndRestaurant(String region, String kind, String restaurant);

    Iterable<VarietyOfDishes> findByRegionAndKindAndPrice(String region, String kind, String price);

    Iterable<VarietyOfDishes> findByRegionAndKind(String region, String kind);

    Iterable<VarietyOfDishes> findByRegionAndCookAndRestaurantAndPrice(String region, String cook, String restaurant, String price);

    Iterable<VarietyOfDishes> findByRegionAndCookAndRestaurant(String region, String cook, String restaurant);

    Iterable<VarietyOfDishes> findByRegionAndCookAndPrice(String region, String cook, String price);

    Iterable<VarietyOfDishes> findByRegionAndCook(String region, String cook);

    Iterable<VarietyOfDishes> findByRegionAndRestaurantAndPrice(String region,String restaurant, String price);

    Iterable<VarietyOfDishes> findByRegionAndRestaurant(String region, String restaurant);

}
