package cn.edu.upc.yb.integrate.express.repository;

import cn.edu.upc.yb.integrate.express.model.ExpressAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

/**
 * Created by wanghaojun on 2016/10/21.
 */
public interface ExpressAddressRepository extends CrudRepository<ExpressAddress,Integer>{
    Iterator<ExpressAddress> findByYibanid(int yibanid);
}
