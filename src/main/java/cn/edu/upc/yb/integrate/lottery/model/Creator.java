package cn.edu.upc.yb.integrate.lottery.model;

import javax.persistence.*;

/**
 * Created by skyADMIN on 16/2/4.
 */
@Entity
@Table(name = "lottery_creator")
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long yibanid;
    private String yibanname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getYibanid() {
        return yibanid;
    }

    public void setYibanid(long yibanid) {
        this.yibanid = yibanid;
    }

    public String getYibanname() {
        return yibanname;
    }

    public void setYibanname(String yibanname) {
        this.yibanname = yibanname;
    }
}
