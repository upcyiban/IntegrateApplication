package cn.edu.upc.yb.integrate.express.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import cn.edu.upc.yb.integrate.express.model.Order;
import org.aspectj.weaver.ast.Or;

/**
 * Created by wh980 on 2016/9/7.
 */
public interface OrderDao extends CrudRepository<Order,Integer>{
    public Iterable<Order> findAll(Sort sort);

    public Iterable<Order> findByYibanid(String yibanid);

    public Iterable<Order> findByOrdervalue(String ordervalue);

    public Iterable<Order> findById(int id);

}
