package com.example.twoone.presentation.home;

public class Habit {

    private String title;
    private String day;

    public Habit(String title, String day) {
        this.title = title;
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}
