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

    Iterable<VarietyOfDishes> findByRestaurant(String restaurant);

    Iterable<VarietyOfDishes> findByPrice(String price);//有空重写

    Iterable<VarietyOfDishes> findByRestaurantAndPrice(String restaurant,String price);


    Iterable<VarietyOfDishes> findByKindAndPrice(String kind,String price);

    Iterable<VarietyOfDishes> findByKindAndRestaurant(String kind,String restaurant);

    Iterable<VarietyOfDishes> findByKindAndRestaurantAndPrice(String kind,String restaurant,String price);



    Iterable<VarietyOfDishes> findByRegionAndPrice(String region,String price);



    Iterable<VarietyOfDishes> findByRegionAndKindAndRestaurantAndPrice(String region, String kind, String restaurant, String price);

    Iterable<VarietyOfDishes> findByRegionAndKindAndRestaurant(String region, String kind, String restaurant);

    Iterable<VarietyOfDishes> findByRegionAndKindAndPrice(String region, String kind, String price);

    Iterable<VarietyOfDishes> findByRegionAndKind(String region, String kind);


    Iterable<VarietyOfDishes> findByRegionAndRestaurantAndPrice(String region,String restaurant, String price);

    Iterable<VarietyOfDishes> findByRegionAndRestaurant(String region, String restaurant);

}
