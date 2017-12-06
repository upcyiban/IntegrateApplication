package cn.edu.upc.yb.integrate.common.model;

import javax.persistence.*;

/**
 * Created by chenzifeng on 2017/4/6.
 */
@Entity
@Table(name = "common_ybuser")
public class YBUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int userid;
    private String username;
    private String usernick;
    private char usersex;
    private String ybhead;

    public YBUser(int userid, String username, String usernick, char usersex, String ybhead) {
        this.userid = userid;
        this.username = username;
        this.usernick = usernick;
        this.usersex = usersex;
        this.ybhead = ybhead;
    }

    public YBUser() {
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
}
