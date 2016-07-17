package cn.edu.upc.yb.integrate.common.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by skyADMIN on 16/7/17.
 * 用于收集用户反馈
 */
@Entity
@Table(name = "common_feedback")
public class FeedBackMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;
    private String message;
    private LocalDateTime sendtime;
    private String appname;         //反馈错误的应用的名字
    private int ispass;             //是否审核

    public FeedBackMessage() {
    }

    public FeedBackMessage(int yibanid, String message, String appname) {
        this.yibanid = yibanid;
        this.message = message;
        this.appname = appname;
        this.sendtime = LocalDateTime.now();
        this.ispass = 0;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSendtime() {
        return sendtime;
    }

    public void setSendtime(LocalDateTime sendtime) {
        this.sendtime = sendtime;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public int getIspass() {
        return ispass;
    }

    public void setIspass(int ispass) {
        this.ispass = ispass;
    }
}
