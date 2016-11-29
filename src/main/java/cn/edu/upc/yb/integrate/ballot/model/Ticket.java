package cn.edu.upc.yb.integrate.ballot.model;

import javax.persistence.*;

/**
 * Created by Jaxlying on 2016/11/29.
 */
@Entity
@Table(name = "ballot_ticket")
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ballot_id")
    private Ballot ballot;

    private int ybid;

    private String ybname;

    public Ticket(Ballot ballot, int ybid, String ybname) {
        this.ballot = ballot;
        this.ybid = ybid;
        this.ybname = ybname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ballot getBallot() {
        return ballot;
    }

    public void setBallot(Ballot ballot) {
        this.ballot = ballot;
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
}
