package com.justdo.oauth2.config.auth;

import com.justdo.oauth2.user.domain.User;

public class SessionUser {
    private String name;
    private String email;

    public SessionUser(User user) {
        name = user.getName();
        email = user.getEmail();
    }

    @Override
    public String toString() {
        return "SessionUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
