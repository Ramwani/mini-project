package com.example.seminar;

import java.sql.Time;
import java.util.Date;

public class BookModel {
    private String event;
    private String department;
    private String Username;
    private Date date;
    private Time time;
    private String hallName;

    public BookModel() {

    }

    public BookModel(String event, String department, String username, Date date, Time time, String hallName) {
        this.event = event;
        this.department = department;
        this.Username = username;
        this.date = date;
        this.time = time;
        this.hallName = hallName;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
}
