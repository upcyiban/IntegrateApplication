package cn.edu.upc.yb.integrate.calendar.model;

import javax.persistence.*;

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
    private int begindate;
    private int enddate;

    public SchoolCalendar() {
    }

    public SchoolCalendar(String schoolschedule, int begindate, int enddate) {
        this.schoolschedule = schoolschedule;
        this.begindate = begindate;
        this.enddate = enddate;
    }

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

    public int getBegindate() {
        return begindate;
    }

    public void setBegindate(int begindate) {
        this.begindate = begindate;
    }

    public int getEnddate() {
        return enddate;
    }

    public void setEnddate(int enddate) {
        this.enddate = enddate;
    }
}
