package cn.edu.upc.yb.integrate.second.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@Entity
@Table(name = "second_publish")
@JsonIgnoreProperties(value = {"isdelete", "createtime", "updatatime"})
public class Publish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String imgurl;
    private String title;
    private String detail;
    private String qq;
    private String telephone;
    private String price;
    private String species;
    private String degree;
    private int ybid;
    private String ybname;
    private String ybhead;
    private int isdeal = 0;

    private String createtime;
    private String updatatime;
    private boolean isdelete = false;

    public Publish() {
    }

    public Publish(String imgurl, String title, String detail, String qq,String telephone, String price, String species,String degree,int ybid,String ybname,String ybhead) {
        this.imgurl = imgurl;
        this.title = title;
        this.detail = detail;
        this.qq = qq;
        this.telephone = telephone;
        this.price = price;
        this.species = species;
        this.degree = degree;//崭新度
        this.id = ybid;
        this.ybname = ybname;
        this.ybhead = ybhead;
        this.createtime = new Date().toString();
        this.updatatime = new Date().toString();
    }

    public void updata(String imgurl, String title, String detail, String qq,String telephone, String price, String species,String degree,int isdeal){
        this.imgurl = imgurl;
        this.title = title;
        this.detail = detail;
        this.qq = qq;
        this.telephone = telephone;
        this.price = price;
        this.species = species;
        this.degree = degree;
        this.updatatime = new Date().toString();
        this.isdeal = isdeal;

    }

    public void delete(){
        this.isdelete = true;
        this.updatatime = new Date().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getYbid() {
        return ybid;
    }

    public void setYbid(int ybid) {
        this.ybid = ybid;
    }

    public String getYbname() {
        return ybname;
    }

    public void setYbname(String ybname) {
        this.ybname = ybname;
    }

    public String getYbhead() {
        return ybhead;
    }

    public void setYbhead(String ybhead) {
        this.ybhead = ybhead;
    }

    public int isdeal() {
        return isdeal;
    }

    public void setIsdeal(int isdeal) {
        this.isdeal = isdeal;
    }
}
