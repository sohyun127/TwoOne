package com.example.twoone.presentation.home;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twoone.data.DbManager;
import com.example.twoone.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

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
    }

    public void setAdapter() {
        arrayList = new ArrayList<>();

        recyclerView = binding.rvHome;
        recyclerView.setHasFixedSize(true);

        try {
            DbManager dbManager = new DbManager(this);
            SQLiteDatabase database = dbManager.getReadableDatabase();

            Cursor cursor = database.rawQuery("select title,day from habit", null);

            while (cursor.moveToNext()) {
                Habit habit = new Habit(cursor.getString(0), cursor.getString(1));
                Log.d("test", habit.toString());
                arrayList.add(habit);
            }
        } catch (Exception e) {
            Log.d("dbError", e.toString());
        }

        adapter = new HabitAdapter(arrayList,getApplicationContext());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }
}
