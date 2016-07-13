package cn.edu.upc.yb.integrate.lostandfound.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2016/7/12.
 */
@Entity
@Table(name = "official")
public class Official {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String detail;
    private int status;
    private String date;
    private String category;
    private boolean isdelet = false;

    public Official(String title, String detail, String date) {
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.setStatus(0);
    }

    public Official() {
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getIsdelet() {
        return isdelet;
    }

    public void setIsdelet(boolean isdelet) {
        this.isdelet = isdelet;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}