package com.books.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    private String username;
    @Column
    private String type;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




}
