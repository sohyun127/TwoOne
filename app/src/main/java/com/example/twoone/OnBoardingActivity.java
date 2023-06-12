package com.example.twoone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twoone.databinding.ActivityOnBoardingBinding;
import com.example.twoone.presentation.onboarding.ChallengeActivity;

public class OnBoardingActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityOnBoardingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnOnBoarding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_on_boarding:
                startActivity(new Intent(this, ChallengeActivity.class));
                finish();
        }
    }
}