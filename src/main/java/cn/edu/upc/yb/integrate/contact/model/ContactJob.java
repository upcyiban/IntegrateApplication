package cn.edu.upc.yb.integrate.contact.model;

import javax.persistence.*;

/**
 * Created by lenovo on 2017/3/25.
 */
@Entity
@Table(name = "ContactJob")
public class ContactJob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String number;
    private int unitid;

    public ContactJob(String name, String number, int unitid) {
        this.name = name;
        this.number = number;
        this.unitid = unitid;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getUnitid() {
        return unitid;
    }

    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }
}
