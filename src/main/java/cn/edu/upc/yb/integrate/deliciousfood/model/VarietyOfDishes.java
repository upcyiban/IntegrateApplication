package cn.edu.upc.yb.integrate.deliciousfood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by 陈子枫 on 2017/2/6.
 */
@Entity
@Table(name = "varietyofdishes")
@JsonIgnoreProperties(value = {"isDelete", "creatAt","updataAt"})
public class VarietyOfDishes {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;//菜名
    private String region;//地域(地方菜)
    private String kind;//种类（酸，甜口味）
    private String restaurant;//餐厅
    private String price;
    private String path;//图片地址
    private  double num = 0;//评分
    private  double sum = 0;
    private int time = 0;//评价次数

    private String introduce;
    private boolean isDelete;
    private long creatAt;
    private long updataAt;

    public VarietyOfDishes(String name, String region, String kind, String restaurant, String price, String path) {
        this.name = name;
        this.region = region;
        this.kind = kind;
        this.restaurant = restaurant;
        this.price = price;
        this.path = path;
        this.isDelete = false;
        this.creatAt = System.currentTimeMillis();
        this.updataAt = creatAt;
    }

    public VarietyOfDishes(String name, String region, String kind, String restaurant, String price, String path, String introduce) {
        this.name = name;
        this.region = region;
        this.kind = kind;
        this.restaurant = restaurant;
        this.price = price;
        this.path = path;
        this.introduce = introduce;
        this.isDelete = false;
        this.creatAt = System.currentTimeMillis();
        this.updataAt = creatAt;
    }

    public VarietyOfDishes() {
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updataAt = System.currentTimeMillis();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
        this.updataAt = System.currentTimeMillis();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
        this.updataAt = System.currentTimeMillis();
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
        this.updataAt = System.currentTimeMillis();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        this.updataAt = System.currentTimeMillis();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        sum  += num;
        time++;
        this.num = sum/time;
        this.updataAt = System.currentTimeMillis();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public boolean isdelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        this.isDelete = delete;
    }

    public long getCreatAt() {
        return creatAt;
    }

    public long getUpdataAt() {
        return updataAt;
    }

    public void setUpdataAt() {
        this.updataAt = System.currentTimeMillis();
    }
}
