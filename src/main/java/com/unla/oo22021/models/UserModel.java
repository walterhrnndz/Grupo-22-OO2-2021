package com.unla.oo22021.models;

public class UserModel {

    private long id;
    private String username;
    private String password;

    public UserModel() {
    }

    public UserModel(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}