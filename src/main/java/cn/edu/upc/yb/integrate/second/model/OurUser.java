package cn.edu.upc.yb.integrate.second.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@Entity
@Table(name = "second_ouruser")
@JsonIgnoreProperties(value = {"isdelete", "createtime", "updatatime"})
public class OurUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int userid;
    private String username;
    private String usernick;
    private char usersex;
    private String ybhead;

    private String createtime;
    private String updatatime;
    private boolean isdelete = false;

    public OurUser() {
    }

    public OurUser(int userid, String username, String usernick, char usersex, String ybhead) {
        this.userid = userid;
        this.username = username;
        this.usernick = usernick;
        this.usersex = usersex;
        this.ybhead = ybhead;
        this.createtime = new Date().toString();
        this.updatatime = new Date().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernick() {
        return usernick;
    }

    public void setUsernick(String usernick) {
        this.usernick = usernick;
    }

    public char getUsersex() {
        return usersex;
    }

    public void setUsersex(char usersex) {
        this.usersex = usersex;
    }

    public String getYbhead() {
        return ybhead;
    }

    public void setYbhead(String ybhead) {
        this.ybhead = ybhead;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatatime() {
        return updatatime;
    }

    public void setUpdatatime(String updatatime) {
        this.updatatime = updatatime;
    }

    public boolean isdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }
}
