package cn.edu.upc.yb.integrate.bulletinboard.model;

import javax.persistence.*;

/**
 * Created by skyADMIN on 16/7/7.
 */
@Entity
@Table(name = "bulletinadminuser")
public class BulletinAdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



}
