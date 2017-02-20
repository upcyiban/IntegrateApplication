package cn.edu.upc.yb.integrate.deliciousfood.dto;

import org.springframework.data.jpa.domain.Specifications;

/**
 * Created by 陈子枫 on 2017/2/17.
 */
public class SearchSpeDto {

    private Specifications spes;
    private String name;//菜名
    private String region;//地域(地方菜)
    private String kind;//种类（酸，甜口味）
    private String cook;//做法（蒸，煮，炸。。）
    private String restaurant;//餐厅

    public SearchSpeDto(Specifications spes, String name, String region, String kind, String cook, String restaurant) {
        this.spes = spes;
        this.name = name;
        this.region = region;
        this.kind = kind;
        this.cook = cook;
        this.restaurant = restaurant;
    }

    public SearchSpeDto() {
    }

    public Specifications getSpes() {
        return spes;
    }

    public void setSpes(Specifications spes) {
        this.spes = spes;
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
}
