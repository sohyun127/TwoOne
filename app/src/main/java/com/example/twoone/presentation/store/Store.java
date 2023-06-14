package com.example.twoone.presentation.store;

import android.graphics.drawable.Drawable;

public class Store {

    private String title; //상점 타이틀
    private int img;//상점 이미지

    public Store(String title, int img) {
        this.title = title;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
