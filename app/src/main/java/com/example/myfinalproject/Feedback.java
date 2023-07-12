package com.example.myfinalproject;

public class Feedback {
    private float rating;
    private String feedback;


    public Feedback() {
        // Default constructor required for Firebase
    }

    public Feedback(float rating ,String feedback) {
        this.rating = rating;
        this.feedback = feedback;

    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback= feedback;
    }
}