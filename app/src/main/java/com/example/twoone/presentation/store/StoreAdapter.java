package com.example.twoone.presentation.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twoone.databinding.ItemStoreBinding;
import com.example.twoone.presentation.home.StampAdapter;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {


    private Context context;
    private ArrayList<Store> arrayList;


    @NonNull
    @Override
    public StoreAdapter.StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStoreBinding binding = ItemStoreBinding.inflate(LayoutInflater.from(context), parent, false);
        return new StoreViewHolder(binding);
    }

    public StoreAdapter(ArrayList<Store> arrayList, Context context, StoreAdapter.OnItemClickListener listener) {
        this.context = context;
        this.mListener = listener;
        this.arrayList = arrayList;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    private StoreAdapter.OnItemClickListener mListener = null;

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.StoreViewHolder holder, int position) {
        holder.bindItem(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class StoreViewHolder extends RecyclerView.ViewHolder {
        ItemStoreBinding binding;

        public StoreViewHolder(ItemStoreBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        void bindItem(Store item) {
            binding.ivItemStore.setImageResource(item.getImg());
            binding.tvItemStore.setText(item.getTitle());
        }

    }
}
