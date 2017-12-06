package cn.edu.upc.yb.integrate.competiton.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/4/9.
 */
@Entity
@Table(name = "Medal")
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanId;
    private String ybname;
    private int number;

    private boolean finish1=false;
    private boolean finish2=false;
    private boolean finish3=false;
    private boolean finish4=false;
    private boolean finish5=false;

    public Medal(int yibanId, String ybname, int number, boolean finish1, boolean finish2, boolean finish3, boolean finish4, boolean finish5) {
        this.yibanId = yibanId;
        this.ybname = ybname;
        this.number = number;
        this.finish1 = finish1;
        this.finish2 = finish2;
        this.finish3 = finish3;
        this.finish4 = finish4;
        this.finish5 = finish5;
    }

    public Medal(int yibanId, String ybname, int number) {
        this.yibanId = yibanId;
        this.ybname = ybname;
        this.number = number;
    }

    public boolean isFinish1() {
        return finish1;
    }

    public void setFinish1(boolean finish1) {
        this.finish1 = finish1;
    }

    public boolean isFinish2() {
        return finish2;
    }

    public void setFinish2(boolean finish2) {
        this.finish2 = finish2;
    }

    public boolean isFinish3() {
        return finish3;
    }

    public void setFinish3(boolean finish3) {
        this.finish3 = finish3;
    }

    public boolean isFinish4() {
        return finish4;
    }

    public void setFinish4(boolean finish4) {
        this.finish4 = finish4;
    }

    public boolean isFinish5() {
        return finish5;
    }

    public void setFinish5(boolean finish5) {
        this.finish5 = finish5;
    }

    public Medal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYibanId() {
        return yibanId;
    }

    public void setYibanId(int yibanId) {
        this.yibanId = yibanId;
    }

    public String getYbname() {
        return ybname;
    }

    public void setYbname(String ybname) {
        this.ybname = ybname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
