package cn.edu.upc.yb.integrate.deliciousfood.dao;

import cn.edu.upc.yb.integrate.deliciousfood.model.ReviewFood;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 陈子枫 on 2017/3/23.
 */
public interface ReviewFoodDao extends CrudRepository<ReviewFood,Integer> {
    Iterable<ReviewFood> findByDishesIdOrderByUpdateTime(int id);
}
