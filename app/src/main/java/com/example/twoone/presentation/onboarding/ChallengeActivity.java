package com.example.twoone.presentation.onboarding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twoone.databinding.ActivityChallengeBinding;

public class ChallengeActivity extends AppCompatActivity {

    private ActivityChallengeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChallengeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}
