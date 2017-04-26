package cn.edu.upc.yb.integrate.InstructorEvaluate.service;

import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.InstructorDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lhy95 on 2017/4/26.
 */
@Service
public class InstructorService {

    @Autowired
    private InstructorDao instructorDao;

    // 获取所有的辅导员，因为是二级菜单，需要整理成json格式
    public HashMap<String, Object> getAllInstructor() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        // 获取所有辅导员信息
        Iterable<Instructor> instructors = instructorDao.findAll();
        // 遍历Iterable
        for (Instructor instructor : instructors) {
            // 如果hashmap中没有这个key，则创建key对应空数组
            map.computeIfAbsent(instructor.getAcademy(), k -> new ArrayList());
            ArrayList temp = (ArrayList) map.get(instructor.getAcademy());
            temp.add(instructor);
        }
        return map;
    }
}
