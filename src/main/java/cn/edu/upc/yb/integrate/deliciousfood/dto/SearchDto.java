package cn.edu.upc.yb.integrate.deliciousfood.dto;

/**
 * Created by 陈子枫 on 2017/2/17.
 */
public class SearchDto {

    private String key;
    private String operation;
    private Object value;
    private String name;//菜名
    private String region;//地域(地方菜)
    private String kind;//种类（酸，甜口味）
    private String cook;//做法（蒸，煮，炸。。）
    private String restaurant;//餐厅

    public SearchDto(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public SearchDto(String key, String operation, Object value, String name, String region, String kind, String cook, String restaurant) {
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.name = name;
        this.region = region;
        this.kind = kind;
        this.cook = cook;
        this.restaurant = restaurant;
    }

    public String getOperation() {
        return operation;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
