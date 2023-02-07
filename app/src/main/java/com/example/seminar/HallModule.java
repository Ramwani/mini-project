package com.example.seminar;

import android.net.Uri;

import java.io.Serializable;

public class HallModule implements Serializable {
    private String id;
    private String title;
    private String capacity;
    private String location;
    private String description;
    private String image;
    private boolean show;
    private Uri uri;

    public HallModule(){

    }

    public HallModule(String id, String title, String capacity, String location, String description, String image, boolean show){
        this.id=id;
        this.title=title;
        this.capacity=capacity;
        this.location=location;
        this.description=description;
        this.image=image;
        this.show=show;
        this.uri=uri;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
