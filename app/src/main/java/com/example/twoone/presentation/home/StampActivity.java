package com.example.twoone.presentation.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twoone.R;
import com.example.twoone.databinding.ActivityStampBinding;

public class StampActivity extends AppCompatActivity {

    ActivityStampBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStampBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setData();
        setClickEventOnNavigation();


    }

    private void setData() {
        binding.tvStampTitle.setText(getIntent().getStringExtra("title"));
        binding.tvStampDay.setText(getIntent().getStringExtra("day") + "일째");
    }

    private void setClickEventOnNavigation() {
        binding.tbStampToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("도전을 포기하시겠어요?\n 삭제된 도전은 복구할 수 없어요.");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
