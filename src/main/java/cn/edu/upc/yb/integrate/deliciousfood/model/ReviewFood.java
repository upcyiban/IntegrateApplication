package cn.edu.upc.yb.integrate.deliciousfood.model;

import javax.persistence.*;

/**
 * Created by 陈子枫 on 2017/3/23.
 */
@Entity
@Table(name = "review")
public class ReviewFood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private int dishesId;//用于和菜品绑定
    private int userId;//用于和用户绑定
    private String detail;
    private long updateTime;

    public ReviewFood(int dishesid, int userId, String detail) {
        this.dishesId = dishesid;
        this.userId = userId;
        this.detail = detail;
        this.updateTime = System.currentTimeMillis();
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


}
