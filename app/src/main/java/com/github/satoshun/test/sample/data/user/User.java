package com.github.satoshun.test.sample.data.user;

public class User {
    private final String id;
    private final String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
