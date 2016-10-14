package cn.edu.upc.yb.integrate.deliverwater.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 陈子枫 on 2016/9/29.
 */
@Entity
@Table(name = "deliverwater")
public class DeliverWater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;
    private String blockNumber;
    private String dormitory;
    private String name;
    private String phone;
    private int num;
    private long createAt;
    private long upAt;
    private long deleteAt;

    public DeliverWater(String blockNumber, String dormitory, String name, String phone, int num) {
        this.blockNumber = blockNumber;
        this.dormitory = dormitory;
        this.name = name;
        this.phone = phone;
        this.num = num;
        this.createAt = System.currentTimeMillis();
    }

    public DeliverWater(String blockNumber, String dormitory, String name, String phone) {
        this.blockNumber = blockNumber;
        this.dormitory = dormitory;
        this.name = name;
        this.phone = phone;
        this.createAt = System.currentTimeMillis();
    }

    public DeliverWater(int yibanid, String blockNumber, String dormitory, String name, String phone) {
        this.yibanid = yibanid;
        this.blockNumber = blockNumber;
        this.dormitory = dormitory;
        this.name = name;
        this.phone = phone;
        this.createAt = System.currentTimeMillis();
    }

    public DeliverWater() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }
}
