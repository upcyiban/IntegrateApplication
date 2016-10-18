package cn.edu.upc.yb.integrate.express.model;

import javax.persistence.*;

/**
 * Created by wh980 on 2016/10/14.
 */
@Entity
@Table(name = "express_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;
    private String address;
    private boolean uservalue=false;
    private String moblienumber;
    private String name;

    public User(int yibanid, String address, boolean uservalue, String moblienumber, String name) {
        this.yibanid = yibanid;
        this.address = address;
        this.uservalue = uservalue;
        this.moblienumber = moblienumber;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getYibanid() {
        return yibanid;
    }

    public String getAddress() {
        return address;
    }

    public boolean isUservalue() {
        return uservalue;
    }

    public String getMoblienumber() {
        return moblienumber;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUservalue(boolean uservalue) {
        this.uservalue = uservalue;
    }

    public void setMoblienumber(String moblienumber) {
        this.moblienumber = moblienumber;
    }

    public void setName(String name) {
        this.name = name;
    }
}
