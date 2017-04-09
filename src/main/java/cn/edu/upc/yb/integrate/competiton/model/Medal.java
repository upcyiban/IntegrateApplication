package cn.edu.upc.yb.integrate.competiton.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/4/9.
 */
@Entity
@Table(name = "Medal")
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanId;
    private String ybname;
    private int number;

    public Medal(int yibanId, String ybname, int number) {
        this.yibanId = yibanId;
        this.ybname = ybname;
        this.number = number;
    }

    public Medal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYibanId() {
        return yibanId;
    }

    public void setYibanId(int yibanId) {
        this.yibanId = yibanId;
    }

    public String getYbname() {
        return ybname;
    }

    public void setYbname(String ybname) {
        this.ybname = ybname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
