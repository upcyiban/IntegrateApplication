package cn.edu.upc.yb.integrate.InstructorEvaluate.service;

import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.InstructorDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.RecordDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dto.InstructorItem;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Instructor;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Record;
import cn.edu.upc.yb.integrate.common.util.JsonWebToken;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lhy95 on 2017/4/26.
 */
@Service
public class InstructorService {

    private final InstructorDao instructorDao;
    private final JsonWebToken jsonWebToken;
    private final RecordDao recordDao;

    @Autowired
    public InstructorService(InstructorDao instructorDao, JsonWebToken jsonWebToken, RecordDao recordDao) {
        this.instructorDao = instructorDao;
        this.jsonWebToken = jsonWebToken;
        this.recordDao = recordDao;
    }

    // 获取所有的辅导员，因为是二级菜单，需要整理成json格式
    public HashMap<String, Object> getAllInstructor() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        // 获取所有辅导员信息
        Iterable<Instructor> instructors = instructorDao.findAll();
        // 遍历Iterable
        for (Instructor instructor : instructors) {
            // 如果hashmap中没有这个key，则创建key对应空数组
            map.computeIfAbsent(instructor.getAcademy(), k -> new ArrayList());
            List temp = (ArrayList) map.get(instructor.getAcademy());
            temp.add(instructor);
        }
        return map;
    }

    // 存一条评价
    public Integer saveRecord(String token, int score, int instructorId, String message) {

        Claims claims = jsonWebToken.getClaimsFromToken(token);
        HashMap student;
        if (claims != null) {
            student = (HashMap) claims.get("user");
        } else {
            return 1;
        }

        Record record = new Record((Integer) student.get("id"), instructorId, score, message);
        recordDao.save(record);
        return 0;
    }

    public ArrayList getAllEvaluate() {
        ArrayList instructorList = new ArrayList();

        Iterable<Instructor> instructors = instructorDao.findAll();
        for (Instructor instructor : instructors) {
            double score = calculateScore(instructor.getId());
            InstructorItem instructorItem = new InstructorItem(instructor, score);
            instructorList.add(instructorItem);
        }
        return instructorList;
    }

    // 计算某个辅导员的平均分
    private double calculateScore(int instructorId) {
        Iterable<Record> records = recordDao.findByInstructorId(instructorId);
        int num = 0;
        double total = 0;
        for (Record record : records) {
            total += record.getScore();
            num++;
        }
        if (num == 0) {
            return 0;
        } else {
            return total/num;
        }
    }
}
