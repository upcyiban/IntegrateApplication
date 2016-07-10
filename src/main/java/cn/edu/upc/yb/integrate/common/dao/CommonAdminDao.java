package cn.edu.upc.yb.integrate.common.dao;

import cn.edu.upc.yb.integrate.common.model.CommonAdmin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/7/10.
 */
public interface CommonAdminDao extends CrudRepository<CommonAdmin, Integer> {
    public Iterable<CommonAdmin> findByYibanid(int Yibanid);
}
