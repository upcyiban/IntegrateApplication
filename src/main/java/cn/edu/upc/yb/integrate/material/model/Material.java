package cn.edu.upc.yb.integrate.material.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/2/9.
 */
@Entity
@Table(name = "Material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;//物资名称
    private String organization;//物资所属单位
    private String description;//物资描述

    private int number;//物资现有数目
    private int totalNumber;//物资总数

    private boolean status;//物资是否可借

    public Material() {
    }

    public Material(String name, String organization, String description, int number, int totalnumber) {

        this.name = name;
        this.organization = organization;
        this.description = description;
        this.number = number;
        this.totalNumber = totalnumber;
        this.status = status;
    }
    public Material(String name, String organization, String description,  int totalnumber) {

        this.name = name;
        this.organization = organization;
        this.description = description;
        this.number = number;
        this.totalNumber = totalnumber;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
