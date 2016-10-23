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


    public Tab(String name) {
        this.name = name;
    }
    public Tab(){}

    public Integer getId() {
        return id;
    }



    public String getName() {
        return name;
    }






    public void update(String name){
        this.name = name;
    }


}
