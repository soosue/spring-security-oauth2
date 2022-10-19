package com.justdo.oauth2.user.domain;

public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자"),
    ACTIVIST("ROLE_ACTIVIST", "활동가"),
    RE100_ACTIVIST("ROLE_RE100_ACTIVIST", "re100 활동가");

    private final String key;
    private final String title;

    Role(String key, String title) {
        this.key = key;
        this.title = title;
    }

    public String getKey() {
        return key;
    }
}
