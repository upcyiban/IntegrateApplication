package cn.edu.upc.yb.integrate.express.dao;
import org.springframework.data.repository.CrudRepository;
import cn.edu.upc.yb.integrate.express.model.Order;

/**
 * Created by wh980 on 2016/9/7.
 */
public interface OrderDao extends CrudRepository<Order,Integer>{
}
