package cn.edu.upc.yb.integrate.deliciousfood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by 陈子枫 on 2017/2/6.
 */
@Entity
@Table(name = "food_user")
@JsonIgnoreProperties(value = {"isdelete", "creat"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String ybhead;
    private char usersex;

    private boolean isdelete;
    private long createtime;

    public User(String username, String ybhead, char usersex) {
        this.username = username;
        this.ybhead = ybhead;
        this.usersex = usersex;
        this.createtime = System.currentTimeMillis();
        this.isdelete =false;
    }

    public User() {
    }

    public String getYbhead() {
        return ybhead;
    }

    public void setYbhead(String ybhead) {
        this.ybhead = ybhead;
    }

    public char getUsersex() {
        return usersex;
    }

    public void setUsersex(char usersex) {
        this.usersex = usersex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
