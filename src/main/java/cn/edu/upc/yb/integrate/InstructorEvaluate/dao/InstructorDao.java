package cn.edu.upc.yb.integrate.InstructorEvaluate.dao;

import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Instructor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lhy95 on 2017/4/26.
 */
public interface InstructorDao extends CrudRepository<Instructor, Integer> {
    Iterable<Instructor> findByName(String name);
    Iterable<Instructor> findByNumber(String number);
}
