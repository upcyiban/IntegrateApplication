package cn.edu.upc.yb.integrate.bulletinboard.model;

import javax.persistence.*;

/**
 * Created by skyADMIN on 16/7/7.
 */
@Entity
@Table(name = "bulletinadminuser")
public class BulletinAdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;
    private String yibanname;

    public BulletinAdminUser() {
    }

    public BulletinAdminUser(int yibanid, String yibanname) {
        this.yibanid = yibanid;
        this.yibanname = yibanname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }

    public String getYibanname() {
        return yibanname;
    }

    public void setYibanname(String yibanname) {
        this.yibanname = yibanname;
    }
}
