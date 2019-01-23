package com.backend.backend.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @Column
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int ID;

    @Column
    @Max(value = 255, message = "Max length 255")
    private String fName;

    @Column
    @Max(value = 255, message = "Max length 255")
    private String lName;

    public Profile(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
