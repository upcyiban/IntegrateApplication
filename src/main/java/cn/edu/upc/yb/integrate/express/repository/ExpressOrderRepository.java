package cn.edu.upc.yb.integrate.express.repository;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import cn.edu.upc.yb.integrate.express.model.ExpressOrder;

import java.util.Iterator;

/**
 * Created by wh980 on 2016/9/7.
 */
public interface ExpressOrderRepository extends CrudRepository<ExpressOrder,Integer>{
    Iterable<ExpressOrder> findByYibanid(int yibanid);
    Iterator<ExpressOrder> findById(int id);
}
