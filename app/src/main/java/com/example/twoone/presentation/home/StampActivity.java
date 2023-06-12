package com.example.twoone.presentation.home;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import com.example.twoone.R;
import com.example.twoone.databinding.ActivityStampBinding;

public class StampActivity extends Activity {

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

        binding.tbStampToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.delete:
                        AlertDialog.Builder builder = new AlertDialog.Builder(StampActivity.this);
                        builder.setMessage("도전을 포기하시겠어요?\n삭제된 도전은 복구할 수 없어요.\n\n");

                        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        builder.show();
                        return true;
                }
                return false;
            }
        });
    }

}
