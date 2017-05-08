package cn.edu.upc.yb.integrate.InstructorEvaluate.model;

import javax.persistence.*;

/**
 * Created by lhy95 on 2017/4/26.
 */
@Entity
@Table(name = "InstructorEvaluate_instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // 学院
    private String academy;
    // 姓名
    private String name;
    // 工号
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
