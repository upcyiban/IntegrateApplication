package cn.edu.upc.yb.integrate.instructorEvaluate;

import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.InstructorDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.StudentDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Instructor;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Student;
import cn.edu.upc.yb.integrate.IntegrateApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

/**
 * Created by lhy95 on 2017/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrateApplication.class)
@WebAppConfiguration
public class InstructorTest {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private InstructorDao instructorDao;

//    该测试用于检查数据，过于浪费时间和性能，平时不用
//    @Test
//    @Transactional
//    public void testStudentToTeacher() {
//        Iterable<Student> students = studentDao.findAll();
//        Iterator<Student> studentIterator = students.iterator();
//        // 错误个数
//        int number = 0;
//        int total = 0;
//        String worngName = "";
//        while (studentIterator.hasNext()) {
//            total++;
//            System.out.println(total);
//            Student student = studentIterator.next();
//            String instructorName = student.getInstructorName();
//            Iterable<Instructor> instructors = instructorDao.findByName(instructorName);
//            Iterator<Instructor> instructorIterator = instructors.iterator();
//            if (instructorIterator.hasNext()) {
//                // 存在，正常
//            } else {
//                worngName = student.getName();
//                number++;
//                System.out.println(number);
//            }
//
//            if (!student.getSecondInstructor().equals("")){
//                total++;
//                String secondInstructorName = student.getInstructorName();
//                Iterable<Instructor> secondInstructors = instructorDao.findByName(secondInstructorName);
//                Iterator<Instructor> secondInstructorIterator = secondInstructors.iterator();
//                if (secondInstructorIterator.hasNext()) {
//                    // 存在，正常
//                } else {
//                    worngName = student.getName();
//                    number++;
//                    System.out.println(number);
//                }
//            }
//        }
//
//        System.out.println(worngName);
//    }

}
