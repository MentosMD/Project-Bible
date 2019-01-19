package com.backend.backend.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Note")
public class Note {
    @Id
    @Column
    @GeneratedValue(generator = "increment")
    private int Id;

    @Column
    @NotNull
    @Max(value = 255, message = "Max length 255")
    private String title;

    @Column
    @NotNull
    @Max(value = 255, message = "Max length 255")
    private String description;
}
