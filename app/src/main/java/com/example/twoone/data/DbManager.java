package com.example.twoone.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.twoone.R;

public class DbManager extends SQLiteOpenHelper {

    public DbManager(Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table routine(title text,day text,stamp text)"); //계획 테이블
        db.execSQL("create table user(coin text,stamp int,character int)"); //사용자 정보 테이블

        db.execSQL("insert into user values('" + "20" + "','" + R.drawable.img_star_sticker + "','" + R.drawable.img_penguin2 + "');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
