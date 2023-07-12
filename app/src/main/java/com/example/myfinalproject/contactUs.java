package com.example.myfinalproject;

public class contactUs {
    private String name;
    private String email;
    private String message;



    public contactUs() {
        // Default constructor required for Firebase
    }

    public contactUs(String name ,String email,String message) {
        this.message =message;
        this.email=email;
        this.name=name;

    }

    public String getname() {
        return name;
    }

    public void setName(String rating) {
        this.name = rating;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String feedback) {
        this.email= feedback;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String feedback) {
        this.message= feedback;
    }
}