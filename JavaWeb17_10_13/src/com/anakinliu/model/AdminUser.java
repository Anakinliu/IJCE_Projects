package com.anakinliu.model;

import java.io.Serializable;

/**
 * Created by Anakinliu on 17.12.10.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class AdminUser implements Serializable{
    private String password;
    private String username;
    private String permissions;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
