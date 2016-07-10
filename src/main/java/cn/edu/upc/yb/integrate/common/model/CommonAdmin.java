package cn.edu.upc.yb.integrate.common.model;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/7/10.
 */
@Entity
@Table(name = "common_admin")
public class CommonAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;

    public CommonAdmin() {
    }

    public CommonAdmin(int yibanid) {
        this.yibanid = yibanid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }
}
