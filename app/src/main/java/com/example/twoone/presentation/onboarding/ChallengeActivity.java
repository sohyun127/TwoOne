package com.example.twoone.presentation.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twoone.R;
import com.example.twoone.databinding.ActivityChallengeBinding;
import com.example.twoone.presentation.home.HomeActivity;

public class ChallengeActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityChallengeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChallengeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnChallenge.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_challenge:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
        }

    }
}
