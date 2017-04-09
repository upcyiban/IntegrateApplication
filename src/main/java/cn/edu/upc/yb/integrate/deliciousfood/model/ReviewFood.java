package cn.edu.upc.yb.integrate.deliciousfood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈子枫 on 2017/3/23.
 */
@Entity
@Table(name = "food_review")
@JsonIgnoreProperties(value = {"updateTime"})
public class ReviewFood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private int dishesId;//用于和菜品绑定
    private int userId;//用于和用户绑定
    private String username;//
    private String detail;
    private String ybphoto;
    private long updateTime;
    private String date;

    public ReviewFood(int dishesid, int userId,String name, String detail,String ybphoto) {
        this.dishesId = dishesid;
        this.userId = userId;
        this.detail = detail;
        this.username = name;
        this.ybphoto = ybphoto;
        this.updateTime = System.currentTimeMillis();
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = formatter.format(currentTime);
    }

    public ReviewFood() {
    }

    public int getDishesId() {
        return dishesId;
    }

    public void setDishesId(int dishesId) {
        this.dishesId = dishesId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getYbphoto() {
        return ybphoto;
    }

    public void setYbphoto(String ybphoto) {
        this.ybphoto = ybphoto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
