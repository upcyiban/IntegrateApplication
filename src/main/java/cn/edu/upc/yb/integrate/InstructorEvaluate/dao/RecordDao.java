package cn.edu.upc.yb.integrate.InstructorEvaluate.dao;

import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Record;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lhy95 on 2017/4/26.
 */
public interface RecordDao extends CrudRepository<Record, Integer> {
    Iterable<Record> findByInstructorId(int instructorId);
    Iterable<Record> findByStudentNumber(String studentNumber);
}
