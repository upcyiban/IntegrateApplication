package cn.edu.upc.yb.integrate.homepage.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ybdevelop on 2016/10/18.
 */
@Entity
@Table(name = "app")
public class App{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public String getHref(){
        return href;
    }
    public Integer getTabid(){
        return tabid;
    }

    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private Integer tabid;
    @Column(nullable = false)
    private String href;

    public App(String name,Integer tabid, String href) {
        this.name = name;
        this.tabid = tabid;
        this.href = href;
    }
    public App(){}

    public void update(String name,Integer tabid,String href){
        this.name = name;
        this.tabid = tabid;
        this.href = href;
    }
}
