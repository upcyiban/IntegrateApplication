package cn.edu.upc.yb.integrate.deliverwater.dao;

import cn.edu.upc.yb.integrate.deliverwater.model.DeliverWater;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 陈子枫 on 2016/9/29.
 */
public interface DeliverWaterDao extends CrudRepository<DeliverWater,Integer> {
    Iterable<DeliverWater> findByIsdeal(boolean isdeal);

}
