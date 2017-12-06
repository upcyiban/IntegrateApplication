package cn.edu.upc.yb.integrate.speaktoteacher.model;



import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/3/29.
 */
@Entity
@Table (name = "Stt_Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;//老师名字
    private String imgurl;//老师头像名字
    private String profile;//个人简介
    private String motto;//座右铭
    private String QRcode;//二维码链接
    private int yibanId;//老师的易班id
    private String recommend;//名师推荐

    private String phonenumber;//手机号
    private String email;//电子邮件

    public Teacher(String name, String imgurl, String profile, String motto, String QRcode, int
            yibanId, String recommend, String phonenumber, String email) {
        this.name = name;
        this.imgurl = imgurl;
        this.profile = profile;
        this.motto = motto;
        this.QRcode = QRcode;
        this.yibanId = yibanId;
        this.recommend = recommend;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public int getYibanId() {
        return yibanId;
    }

    public void setYibanId(int yibanId) {
        this.yibanId = yibanId;
    }

    public String getQRcode() {
        return QRcode;
    }

    public void setQRcode(String QRcode) {
        this.QRcode = QRcode;
    }

    public Teacher() {
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

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
