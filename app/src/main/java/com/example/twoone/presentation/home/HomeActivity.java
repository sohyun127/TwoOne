package com.example.twoone.presentation.home;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twoone.R;
import com.example.twoone.data.DbManager;
import com.example.twoone.databinding.ActivityHomeBinding;
import com.example.twoone.presentation.onboarding.ChallengeActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityHomeBinding binding;

    private RecyclerView.Adapter adapter;
    private ArrayList<Habit> arrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAdapter();
        binding.fabHome.setOnClickListener(this);
    }

    public void setAdapter() {
        arrayList = new ArrayList<>();

        recyclerView = binding.rvHome;
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

        adapter = new HabitAdapter(arrayList, getApplicationContext(), new HabitAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), StampActivity.class);
                intent.putExtra("title", arrayList.get(position).getTitle());
                intent.putExtra("day", arrayList.get(position).getDay());
                startActivity(intent);
                finish();
            }
        });
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_home:
                startActivity(new Intent(this, ChallengeActivity.class));
                finish();
        }

    }
}
