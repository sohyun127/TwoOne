package com.example.twoone;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twoone.data.DbManager;
import com.example.twoone.databinding.ActivityOnBoardingBinding;
import com.example.twoone.presentation.home.HomeActivity;
import com.example.twoone.presentation.onboarding.ChallengeActivity;

public class OnBoardingActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityOnBoardingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnOnBoarding.setOnClickListener(this);
        checkData();
    }


    //계획 리스트에 데이터가 있으면 홈화면으로 넘어가는 함수
    private void checkData() {
        DbManager dbManager = new DbManager(this);
        SQLiteDatabase database = dbManager.getReadableDatabase();

        Cursor cursor = database.rawQuery("select title,day from routine", null);

        if (cursor.moveToNext()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }


    }

    //버튼 클릭 이벤트
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_on_boarding:
                startActivity(new Intent(this, ChallengeActivity.class));
                finish();
        }
    }
}