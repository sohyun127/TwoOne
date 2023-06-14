package com.example.twoone.presentation.home;

public class Habit {

    private String title; //도전하는 습관 타이틀
    private String day; //계획 수행한 날짜

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
