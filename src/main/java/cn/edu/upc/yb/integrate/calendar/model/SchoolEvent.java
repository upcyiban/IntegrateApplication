package cn.edu.upc.yb.integrate.calendar.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jaxlying on 2016/7/9.
 */
@Entity
@Table(name ="schoolevent")
public class SchoolEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String starttime;
    private String endtime;
    private String startdate;
    private String enddate;
    private String detail;
    private String title;

    private String creattime;
    private String updatetime;
    private boolean isdelete = false;


    public SchoolEvent(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SchoolEvent(String starttime, String endtime, String startdate, String enddate, String detail, String title) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.startdate = startdate;
        this.enddate = enddate;
        this.detail = detail;
        this.title = title;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public boolean isdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }
}
