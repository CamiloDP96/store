package com.mystore.Objects;

public class users {
    private String username;
    private String password;

    // Constructor
    public users(String username, String password) {
        this.username = username; //usuario
        this.password = password; //contraseña
    }

    // Getter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
