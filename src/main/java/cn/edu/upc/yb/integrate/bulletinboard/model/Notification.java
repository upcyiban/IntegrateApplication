package cn.edu.upc.yb.integrate.bulletinboard.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by skyADMIN on 16/7/7.
 */
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;

    private String title;
    private String message;
    private String tag;

    private LocalDateTime publishtime;

    public Notification() {
    }

    public Notification(int yibanid, String title, String message) {
        this.yibanid = yibanid;
        this.title = title;
        this.message = message;
        this.tag = "default";
        this.publishtime = LocalDateTime.now();
    }

    public Notification(int yibanid, String title, String message, String tag) {
        this.yibanid = yibanid;
        this.title = title;
        this.message = message;
        this.tag = tag;
        this.publishtime = LocalDateTime.now();
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDateTime getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(LocalDateTime publishtime) {
        this.publishtime = publishtime;
    }
}
