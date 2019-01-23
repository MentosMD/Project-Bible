package com.backend.backend.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column
    @GeneratedValue(generator="increment")
    private int Id;

    @Column
    @NotNull(message = "Email can not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Column
    @NotNull(message = "Password should not be empty")
    @Min(value = 7, message = "Min length 7")
    @Max(value = 32, message = "Max length 32")
    private String password;

    @Column
    @NotNull
    private String token;

    public User(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
