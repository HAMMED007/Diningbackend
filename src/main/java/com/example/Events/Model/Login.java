package com.example.Events.Model;

public class Login {

    String username;
    String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login(){}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
