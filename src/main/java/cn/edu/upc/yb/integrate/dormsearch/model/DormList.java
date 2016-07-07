package cn.edu.upc.yb.integrate.dormsearch.model;

import javax.persistence.*;

/**
 * Created by skyADMIN on 16/6/27.
 */
@Entity
@Table(name = "dormlist")
public class DormList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String number;
    private String name;
    private String dormnumber;

    public DormList() {
    }

    public DormList(String number, String name, String dormnumber) {
        this.number = number;
        this.name = name;
        this.dormnumber = dormnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDormnumber() {
        return dormnumber;
    }

    public void setDormnumber(String dormnumber) {
        this.dormnumber = dormnumber;
    }
}
