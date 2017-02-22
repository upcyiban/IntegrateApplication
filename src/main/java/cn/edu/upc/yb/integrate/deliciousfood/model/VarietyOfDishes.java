package cn.edu.upc.yb.integrate.deliciousfood.model;

import javax.persistence.*;

/**
 * Created by 陈子枫 on 2017/2/6.
 */
@Entity
@Table(name = "varietyofdishes")
public class VarietyOfDishes  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;//菜名
    private String region;//地域(地方菜)
    private String kind;//种类（酸，甜口味）
    private String cook;//做法（蒸，煮，炸。。）
    private String restaurant;//餐厅
    private String price;
    private String imsl;//图片地址
    private double num;//评分


    public VarietyOfDishes(String name, String region, String kind, String cook, String restaurant, String price, String imsl) {
        this.name = name;
        this.region = region;
        this.kind = kind;
        this.cook = cook;
        this.restaurant = restaurant;
        this.price = price;
        this.imsl = imsl;
    }

    public VarietyOfDishes() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCook() {
        return cook;
    }

    public void setCook(String cook) {
        this.cook = cook;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImsl() {
        return imsl;
    }

    public void setImsl(String imsl) {
        this.imsl = imsl;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
