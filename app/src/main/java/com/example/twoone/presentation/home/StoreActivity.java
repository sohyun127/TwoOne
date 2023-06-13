package com.example.twoone.presentation.home;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twoone.R;
import com.example.twoone.databinding.ActivityStoreBinding;
import com.example.twoone.presentation.store.Store;
import com.example.twoone.presentation.store.StoreAdapter;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    private ActivityStoreBinding binding;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAdapter();


    }


    private void setAdapter() {


        recyclerView = binding.rvStore;
        recyclerView.setHasFixedSize(true);

        setData();

        adapter=new StoreAdapter(arrayList, getApplicationContext(), new StoreAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        });

        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void setData() {
        arrayList = new ArrayList<Store>();

        arrayList.add(new Store("기본 ver", R.drawable.img_penguin1_after));
        arrayList.add(new Store("물고기 ver", R.drawable.img_penguin2_after));
        arrayList.add(new Store("수박 ver", R.drawable.img_penguin4_after));
        arrayList.add(new Store("곰돌이 ver", R.drawable.img_penguin3_after));
        arrayList.add(new Store("스쿠버 ver", R.drawable.img_penguin5_after));
        arrayList.add(new Store("하트 ver", R.drawable.img_penguin6_after));

        arrayList.add(new Store("기본 ver", R.drawable.img_start_sticker_after));
        arrayList.add(new Store("물고기 ver", R.drawable.img_fish_sticker_after));
        arrayList.add(new Store("수박 ver", R.drawable.img_fruit_sticker_after));
        arrayList.add(new Store("곰돌이 ver", R.drawable.img_bear_sticker_after));
        arrayList.add(new Store("스쿠버 ver", R.drawable.img_water_sticker_after));
        arrayList.add(new Store("하트 ver", R.drawable.img_hart_sticker_after));

    }
}
