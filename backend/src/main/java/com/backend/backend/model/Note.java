package com.backend.backend.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @Column
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int Id;

    @Column
    @NotNull
    @Max(value = 255, message = "Max length 255")
    private String title;

    @Column
    @NotNull
    @Max(value = 255, message = "Max length 255")
    private String description;

    @Column
    @NotNull
    private int ProfileId;

    public Note(String title, String description, int ProfileId) {
        this.title = title;
        this.description = description;
        this.ProfileId = ProfileId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProfileId() {
        return ProfileId;
    }

    public void setProfileId(int profileId) {
        ProfileId = profileId;
    }
}
