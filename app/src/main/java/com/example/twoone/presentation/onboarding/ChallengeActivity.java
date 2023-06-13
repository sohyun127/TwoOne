package com.example.twoone.presentation.onboarding;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twoone.R;
import com.example.twoone.data.DbManager;
import com.example.twoone.databinding.ActivityChallengeBinding;
import com.example.twoone.presentation.home.HomeActivity;

public class ChallengeActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityChallengeBinding binding;
    private DbManager dbManager;

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
                binding.tvChallengeCount.setText("(" + input.length() + "/15)");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_challenge:
                String habit = binding.etChallengeInput.getText().toString();
                if (habit.isEmpty()) {
                    Toast.makeText(this, "입력을 해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    saveData(habit);
                    startActivity(new Intent(this, HomeActivity.class));
                    finish();
                }

        }

    }


    public void saveData(String title) {
        try {
            dbManager = new DbManager(this);
            SQLiteDatabase database;
            database = dbManager.getWritableDatabase();

            database.execSQL("insert into routine values('" + title + "','" + "0" + "','"+"0"+"');");
            dbManager.close();
        } catch (SQLException e) {
            Log.d("dbError", e.toString());
        }
    }
}
