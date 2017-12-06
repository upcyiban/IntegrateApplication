package cn.edu.upc.yb.integrate.speaktoteacher.repository;

import cn.edu.upc.yb.integrate.speaktoteacher.model.Teacher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/3/29.
 */
public interface TeacherRepository extends CrudRepository<Teacher,Integer> {

   public Teacher findFirstByYibanId(int id);
}
