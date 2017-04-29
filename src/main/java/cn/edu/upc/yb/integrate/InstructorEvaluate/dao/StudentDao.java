package cn.edu.upc.yb.integrate.InstructorEvaluate.dao;

import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lhy95 on 2017/4/26.
 */
public interface StudentDao extends CrudRepository<Student, Integer> {
    Iterable<Student> findByNumberAndPassword(String number, String password);
}
