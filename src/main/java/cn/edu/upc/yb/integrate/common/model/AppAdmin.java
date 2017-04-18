package cn.edu.upc.yb.integrate.common.model;

import javax.persistence.*;

/**
 * Created by lylllcc on 2017/4/2.
 */
@Entity
@Table(name = "app_admin")
public class AppAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String appName;
    private int ybid;

    public AppAdmin(String appName, int ybid) {
        this.appName = appName;
        this.ybid = ybid;
    }

    public AppAdmin(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getYbid() {
        return ybid;
    }

    public void setYbid(int ybid) {
        this.ybid = ybid;
    }
}
