package cn.edu.upc.yb.integrate.second.repository;


import cn.edu.upc.yb.integrate.second.model.OurUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jaxlying on 2016/7/26.
 */
public interface UserRepository extends CrudRepository<OurUser,Integer> {
    public OurUser findByUserid(int userid);
    public OurUser findTopByOrderByCreatetimeDesc();

}
