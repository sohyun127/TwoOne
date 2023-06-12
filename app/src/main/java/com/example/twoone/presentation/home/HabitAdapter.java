package com.example.twoone.presentation.home;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twoone.databinding.ItemHomeBinding;

import java.util.ArrayList;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {

    private ArrayList<Habit> arrayList;
    private Context context;

    public HabitAdapter(ArrayList<Habit> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHomeBinding binding = ItemHomeBinding.inflate(LayoutInflater.from(context), parent, false);
        return new HabitViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
        holder.bindItem(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return (arrayList.size());
    }

    public class HabitViewHolder extends RecyclerView.ViewHolder {
        ItemHomeBinding binding;

        public HabitViewHolder(ItemHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindItem(Habit item) {
            binding.tvItemHomeTitle.setText(item.getTitle());
            String str1 = item.getDay();
            String str2 = " 일을 해냈어요";
            SpannableString spannableString = new SpannableString(str1 + str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA76B")), 0, str1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            binding.tvItemHomeDetail.setText(spannableString);
        }

    }


}
