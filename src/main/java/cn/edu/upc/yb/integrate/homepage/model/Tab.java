package cn.edu.upc.yb.integrate.homepage.model;

import javax.persistence.*;

/**
 * Created by ybdevelop on 2016/10/18.
 */
@Entity
@Table(name = "tab")
public class Tab{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private String url;


    public Tab(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Tab(String name, String url) {
        this.name = name;
        this.url = url;

    }

    public void update(String name, String url){
        this.name = name;
        this.url = url;
    }


}
