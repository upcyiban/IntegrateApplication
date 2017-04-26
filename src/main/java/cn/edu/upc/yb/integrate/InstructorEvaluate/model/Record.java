package cn.edu.upc.yb.integrate.InstructorEvaluate.model;

import javax.persistence.*;

/**
 * Created by lhy95 on 2017/4/26.
 */
@Entity
@Table(name = "InstructorEvaluate_record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // 做出该条评价的学生学号
    private int studentNumber;

    // 评价的辅导员的id
    private int instructorId;

    // 分数
    private int score;

    // 其它意见
    private String message;

    public Record() {
    }

    public Record(int studentNumber, int instructorId, int score, String message) {
        this.studentNumber = studentNumber;
        this.instructorId = instructorId;
        this.score = score;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
