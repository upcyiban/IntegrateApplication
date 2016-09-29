package cn.edu.upc.yb.integrate.deliverwater.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by 陈子枫 on 2016/9/29.
 */
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   private String blockNumber;
   private String dormitory;
   private String name;
   private String phone;
   private int num;
   private long createAt;
   private long upAt;
   private long deleteAt;

    public User(String blockNumber, String dormitory, String name, String phone, int num) {
        this.blockNumber = blockNumber;
        this.dormitory = dormitory;
        this.name = name;
        this.phone = phone;
        this.num = num;
        this.createAt = System.currentTimeMillis();
    }

    public User(String blockNumber, String dormitory, String name, String phone) {
        this.blockNumber = blockNumber;
        this.dormitory = dormitory;
        this.name = name;
        this.phone = phone;
        this.createAt = System.currentTimeMillis();
    }

    public User(){}

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
}
