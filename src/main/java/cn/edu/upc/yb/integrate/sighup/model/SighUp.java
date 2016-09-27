package cn.edu.upc.yb.integrate.sighup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Jaxlying on 2016/9/27.
 */
@Entity
public class SighUp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String sex;
    private String method;
    private String detail;
    private String major;

    public SighUp(String name, String sex, String method, String detail, String major) {
        this.name = name;
        this.sex = sex;
        this.method = method;
        this.detail = detail;
        this.major = major;
    }
}
