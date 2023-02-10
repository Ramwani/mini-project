package com.example.seminar;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {

    private String uid,username,department,email,role;

    private boolean show;

    public Role() {
    }

    public Role(String uid, String username, String department, String email, String role, boolean show) {
        this.uid = uid;
        this.username = username;
        this.department = department;
        this.email = email;
        this.role = role;
        this.show=show;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
