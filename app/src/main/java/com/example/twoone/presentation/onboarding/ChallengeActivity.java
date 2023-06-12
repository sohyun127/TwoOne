package com.example.twoone.presentation.onboarding;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;

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

        //edit text 글자수 세는 리스너
        binding.etChallengeInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = binding.etChallengeInput.getText().toString();
                binding.tvChallengeCount.setText("("+input.length()+"/15)");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
