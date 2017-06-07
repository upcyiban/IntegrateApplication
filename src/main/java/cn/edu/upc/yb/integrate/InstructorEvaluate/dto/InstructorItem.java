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
    // 投票率
    private String voteRate;

    public InstructorItem() {
    }

    public InstructorItem(Instructor instructor, double score) {
        this.score = score;
        this.academy = instructor.getAcademy();
        this.name = instructor.getName();
        this.number = instructor.getNumber();
    }

    public InstructorItem(Instructor instructor, double score, String voteRate) {
        this.score = score;
        this.academy = instructor.getAcademy();
        this.name = instructor.getName();
        this.number = instructor.getNumber();
        this.voteRate = voteRate;
    }

    public String getVoteRate() {
        return voteRate;
    }

    public void setVoteRate(String voteRate) {
        this.voteRate = voteRate;
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

