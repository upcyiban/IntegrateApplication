package cn.edu.upc.yb.integrate.contact.model;

import javax.persistence.*;

/**
 * Created by lenovo on 2017/3/25.
 */
@Entity
@Table(name = "ContactsJob")
public class ContactsJob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String number;
    private int contactsUnitId;

    public ContactsJob() {
    }

    public ContactsJob(String name, String number, int contactsUnitId) {
        this.name = name;
        this.number = number;
        this.contactsUnitId = contactsUnitId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getContactsUnitId() {
        return contactsUnitId;
    }

    public void setContactsUnitId(int contactsUnitId) {
        this.contactsUnitId = contactsUnitId;
    }
}
