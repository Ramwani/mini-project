package com.example.seminar;

import java.sql.Time;
import java.time.Duration;
import java.util.Date;

public class BookModel {
    private String id;
    private String event;
    private String department;
    private String Username;
    private String date;
    private String time;
    private String duration;

    private String hallName;

    public BookModel() {

    }

    public BookModel(String id, String event, String department, String username, String date, String time, String hallName,String duration) {
        this.duration=duration;
        this.id=id;
        this.event = event;
        this.department = department;
        this.Username = username;
        this.date = date;
        this.time = time;
        this.hallName = hallName;
    }

    public BookModel(String id, String event, String dept,String duration, String date, String time) {
        this.duration=duration;
        this.id=id;
        this.event=event;
        this.department=dept;
        this.date=date;
        this.time=time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
}
