package com.justdo.oauth2.user.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.justdo.oauth2.common.domain.BaseEntity;

@Entity
public class User extends BaseEntity {
    private String email;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role = Role.GUEST;

    public User() {
    }

    public User(String name, String email) {
        this.email = email;
        this.name = name;
    }


    public String getRoleKey() {
        return role.getKey();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
