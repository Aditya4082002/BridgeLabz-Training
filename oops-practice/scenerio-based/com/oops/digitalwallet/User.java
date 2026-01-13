package com.oops.digitalwallet;

class User {
    private int userId;
    private String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
