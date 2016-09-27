package cn.edu.upc.yb.integrate.express.model;

import javax.persistence.*;

/**
 * Created by wh980 on 2016/9/7.
 */
@Entity
@Table(name = "express_user")
public class ExpessUser {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private int yibanid;
    private String name;
    private String address;


    public ExpessUser(String name, String telephone, String address) {
        this.name = name;
        this.address = address;
    }

    public ExpessUser() {
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }
}