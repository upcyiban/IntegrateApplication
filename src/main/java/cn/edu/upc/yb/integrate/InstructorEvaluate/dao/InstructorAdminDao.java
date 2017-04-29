package cn.edu.upc.yb.integrate.InstructorEvaluate.dao;

import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lhy95 on 2017/4/29.
 */
public interface InstructorAdminDao extends CrudRepository<Admin, Integer> {
    Iterable<Admin> findByUsernameAndPassword(String username, String password);
}
