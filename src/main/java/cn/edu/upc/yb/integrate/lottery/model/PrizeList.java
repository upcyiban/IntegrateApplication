package cn.edu.upc.yb.integrate.lottery.model;

import javax.persistence.*;

/**
 * Created by skyADMIN on 16/2/4.
 */
@Entity
@Table(name = "lottery_prizelist")
public class PrizeList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int lotteryid;
    private int yibanid;
    private String yibanname;
    private String prize;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLotteryid() {
        return lotteryid;
    }

    public void setLotteryid(int lotteryid) {
        this.lotteryid = lotteryid;
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

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
}
