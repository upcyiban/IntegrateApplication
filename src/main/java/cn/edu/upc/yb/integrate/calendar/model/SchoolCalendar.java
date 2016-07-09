package cn.edu.upc.yb.integrate.calendar.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by skyADMIN on 16/7/3.
 */
@Entity
@Table(name = "calendar")
public class SchoolCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String schoolschedule;
    private String begindate;
    private String enddate;

    private boolean isdelete = false;
    private String creattime;
    private String updatetime;

    public boolean isdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
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

    public SchoolCalendar(String schoolschedule, String begindate, String enddate) {
        this.schoolschedule = schoolschedule;
        this.begindate = begindate;
        this.enddate = enddate;
        this.creattime = new Date().toString();
        this.updatetime = new Date().toString();

    }
    public SchoolCalendar(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolschedule() {
        return schoolschedule;
    }

    public void setSchoolschedule(String schoolschedule) {
        this.schoolschedule = schoolschedule;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}
