package com.example.twoone.presentation.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twoone.R;
import com.example.twoone.data.DbManager;
import com.example.twoone.databinding.ActivityStoreBinding;
import com.example.twoone.presentation.store.Store;
import com.example.twoone.presentation.store.StoreAdapter;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    private ActivityStoreBinding binding;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList arrayList;
    private DbManager dbManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAdapter();
        setClickEventOnNavigation();

    }


    private void setAdapter() {

        arrayList = new ArrayList<Store>();
        recyclerView = binding.rvStore;
        recyclerView.setHasFixedSize(true);

        setData();

        Intent home = new Intent(getApplicationContext(), HomeActivity.class);
        adapter = new StoreAdapter(arrayList, getApplicationContext(), new StoreAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (position == 0) {
                    home.putExtra("img", R.drawable.img_penguin1);
                } else if (position == 1) {
                    home.putExtra("img", R.drawable.img_penguin2);
                } else if (position == 2) {
                    home.putExtra("img", R.drawable.img_penguin4);
                } else if (position == 3) {
                    home.putExtra("img", R.drawable.img_penguin3);
                } else if (position == 4) {
                    home.putExtra("img", R.drawable.img_penguin5);
                } else if (position == 5) {
                    home.putExtra("img", R.drawable.img_penguin6);
                }

                startActivity(home);
                finish();
            }
        });

        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void setData() {
        arrayList.add(new Store("기본 ver", R.drawable.img_penguin1_after));
        arrayList.add(new Store("물고기 ver", R.drawable.img_penguin2_after));
        arrayList.add(new Store("수박 ver", R.drawable.img_penguin4_after));
        arrayList.add(new Store("곰돌이 ver", R.drawable.img_penguin3_after));
        arrayList.add(new Store("스쿠버 ver", R.drawable.img_penguin5_after));
        arrayList.add(new Store("하트 ver", R.drawable.img_penguin6_after));

    }

    private void setClickEventOnNavigation() {
        binding.tbStoreToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        });
    }
}
