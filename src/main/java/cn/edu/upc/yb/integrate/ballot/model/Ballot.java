package cn.edu.upc.yb.integrate.ballot.model;

import javax.persistence.*;

/**
 * Created by Jaxlying on 2016/11/29.
 */
@Entity
@Table(name = "ballot")
public class Ballot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String detail;

    private long deadline;

    private int num;//总数量

    private String picsrc;

    private int yibanid;

    private String yibanName;

    public Ballot(){}


    public Ballot(String detail, long deadline, int num) {
        this.detail = detail;
        this.deadline = deadline;
        this.num = num;
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }

    public String getYibanName() {
        return yibanName;
    }

    public void setYibanName(String yibanName) {
        this.yibanName = yibanName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPicsrc() {
        return picsrc;
    }

    public void setPicsrc(String picsrc) {
        this.picsrc = picsrc;
    }
}
