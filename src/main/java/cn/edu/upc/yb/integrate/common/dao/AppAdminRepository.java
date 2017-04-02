package cn.edu.upc.yb.integrate.common.dao;

import cn.edu.upc.yb.integrate.common.model.AppAdmin;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by lylllcc on 2017/4/2.
 */
public interface AppAdminRepository extends CrudRepository<AppAdmin,Integer>{
    Collection<AppAdmin> findByAppNameAndYbid(String appName,int ybid);
}
