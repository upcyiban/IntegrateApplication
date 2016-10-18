package cn.edu.upc.yb.integrate.express.dao;


import cn.edu.upc.yb.integrate.express.model.ExpressUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wh980 on 2016/9/7.
 */
public interface UserDao extends CrudRepository<ExpressUser,Integer> {
}
