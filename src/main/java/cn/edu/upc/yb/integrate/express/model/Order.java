package cn.edu.upc.yb.integrate.express.model;

import javax.persistence.*;

/**
 * Created by wh980 on 2016/9/7.
 */
@Entity
@Table(name = "express_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;
    private String number;
    private String company;

    private String details;



    private String creattime;
    private String uservalue = "未确认";//用户确认订单
    private String couriervalue = "未接单";//接单员最终确认
    private String ordervalue = "未完成";//确认接单
    private String address;
    public Order() {
    }


    public Order(String creattime, String username, String mobilenumber, String details, String company, String number, int yibanid,String address) {

        this.creattime = creattime;

        this.details = details;
        this.company = company;
        this.number = number;
        this.yibanid = yibanid;

        this.address= address;

    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public int getYibanid() {
        return yibanid;
    }

    public String getNumber() {
        return number;
    }

    public String getCompany() {
        return company;
    }

    public String getDetails() {
        return details;
    }



    public String getCreattime() {
        return creattime;
    }

    public String getUservalue() {
        return uservalue;
    }

    public String getCouriervalue() {
        return couriervalue;
    }

    public String getOrdervalue() {
        return ordervalue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public void setUservalue(String uservalue) {
        this.uservalue = uservalue;
    }

    public void setCouriervalue(String couriervalue) {
        this.couriervalue = couriervalue;
    }

    public void setOrdervalue(String ordervalue) {
        this.ordervalue = ordervalue;
    }

}
