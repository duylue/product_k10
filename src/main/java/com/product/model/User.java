package com.product.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid;
    @Column(name = "username", nullable = true,unique = true)
    private String username;
    @Column(name = "password", nullable = true)
    private String password;
    private String name;

    public User() {
    }

    public User(int uid) {
        this.uid = uid;
    }
}
