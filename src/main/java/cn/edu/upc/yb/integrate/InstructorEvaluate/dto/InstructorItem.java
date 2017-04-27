package cn.edu.upc.yb.integrate.InstructorEvaluate.dto;

import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Instructor;


/**
 * Created by lhy95 on 2017/4/26.
 */
public class InstructorItem {
    // 学院
    private String academy;
    // 姓名
    private String name;
    // 工号
    private String number;
    // 分数
    private double score;

    public InstructorItem() {
    }

    public InstructorItem(Instructor instructor, double score) {
        this.score = score;
        this.academy = instructor.getAcademy();
        this.name = instructor.getName();
        this.number = instructor.getNumber();
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

