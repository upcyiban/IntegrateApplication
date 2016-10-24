package cn.edu.upc.yb.integrate.express.model;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.xml.crypto.Data;

/**
 * Created by wanghaojun on 2016/10/21.
 */
@Entity
@Table(name = "express_address1024")
public class ExpressAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int yibanid;
    private String mobilenumber;
    private String address;
    private String creatdate;

    public ExpressAddress(String name, int yibanid, String mobilenumber, String address,String creatdate) {
        this.name = name;
        this.yibanid = yibanid;
        this.mobilenumber = mobilenumber;
        this.address = address;
        this.creatdate = creatdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(String creatdate) {
        this.creatdate = creatdate;
    }
}
