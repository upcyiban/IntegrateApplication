package cn.edu.upc.yb.integrate.express.model;

import javax.persistence.*;

/**
 * Created by wh980 on 2016/9/7.
 */
@Entity
@Table(name = "express_order_0118")
public class ExpressOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;

    private String number;
    private String company;
    private String details;
    private String creattime;
    private boolean uservalue = false;
    private boolean couriervalue = false;//接单员确认完成
    private boolean ordervalue = true;//订单是否显示


    public ExpressOrder() {
    }

    public ExpressOrder(String number, String company, String details, String creattime, boolean uservalue, boolean couriervalue, boolean ordervalue, String address, String mobilenumber) {

        this.number = number;
        this.company = company;
        this.details = details;
        this.creattime = creattime;
        this.uservalue = uservalue;
        this.couriervalue = couriervalue;
        this.ordervalue = ordervalue;

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

    public boolean getUservalue() {
        return uservalue;
    }

    public boolean getCouriervalue() {
        return couriervalue;
    }

    public boolean getOrdervalue() {
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

    public void setUservalue(boolean uservalue) {
        this.uservalue = uservalue;
    }

    public void setCouriervalue(boolean couriervalue) {
        this.couriervalue = couriervalue;
    }

    public void setOrdervalue(boolean ordervalue) {
        this.ordervalue = ordervalue;
    }

}
