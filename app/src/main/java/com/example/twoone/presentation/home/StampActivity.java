package com.example.twoone.presentation.home;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twoone.R;
import com.example.twoone.data.DbManager;
import com.example.twoone.databinding.ActivityStampBinding;

import java.util.ArrayList;

public class StampActivity extends Activity {

    private ActivityStampBinding binding;
    private DbManager dbManager;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private String title;
    private String day;
    private ArrayList<Habit> arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStampBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        title = getIntent().getStringExtra("title");
        day = getIntent().getStringExtra("day");

        setData();
        setClickEventOnNavigation();
        setAdapter();

    }


    private void setAdapter() {

        arrayList = new ArrayList<>();
        recyclerView = binding.rvStamp;
        recyclerView.setHasFixedSize(true);

        try {
            DbManager dbManager = new DbManager(this);
            SQLiteDatabase database = dbManager.getReadableDatabase();

            Cursor cursor = database.rawQuery("select title,day,stamp from routine", null);

            while (cursor.moveToNext()) {
                Habit habit = new Habit(cursor.getString(0), cursor.getString(1));
                Log.d("test", habit.toString());
                arrayList.add(habit);
            }


        } catch (Exception e) {
            Log.d("dbError", e.toString());
        }

        if (arrayList.size() < 21) {
            while (arrayList.size() < 21) {
                Habit habit = new Habit("", day);
                arrayList.add(habit);
            }
        }


        adapter = new StampAdapter(arrayList, getApplicationContext(), new StampAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                dbManager = new DbManager(getApplicationContext());
                SQLiteDatabase database = dbManager.getWritableDatabase();

                database.execSQL("update routine set day='" + (Integer.parseInt(day) + 1) +
                        "',stamp='" + (Integer.parseInt(day) + 1) + "' where title='" + title + "';");


            }
        });
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        binding.tvStampTitle.setText(title);
        binding.tvStampDay.setText(day + "일째");
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
                                try {
                                    dbManager = new DbManager(getApplicationContext());
                                    SQLiteDatabase database = dbManager.getWritableDatabase();

                                    database.execSQL("delete from routine where title='" + getIntent().getStringExtra("title") + "';");
                                } catch (SQLException e) {
                                    Log.d("dbError", e.toString());
                                }
                                dialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                                finish();
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
