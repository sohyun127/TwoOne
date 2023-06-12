package com.example.twoone.presentation.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twoone.databinding.ItemStampBinding;

public class StampAdapter extends RecyclerView.Adapter<StampAdapter.StampViewHolder> {


    private Context context;

    @NonNull
    @Override
    public StampAdapter.StampViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStampBinding binding = ItemStampBinding.inflate(LayoutInflater.from(context),parent,false);
        return new StampViewHolder(binding);
    }

    public StampAdapter(Context context,StampAdapter.OnItemClickListener listener){
        this.context = context;
        this.mListener=listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    private StampAdapter.OnItemClickListener mListener = null;

    @Override
    public void onBindViewHolder(@NonNull StampAdapter.StampViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 21;
    }

    public class StampViewHolder extends RecyclerView.ViewHolder{
        ItemStampBinding binding;

        public StampViewHolder(ItemStampBinding binding){
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (mListener != null) {
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });
        }

        void bindItem(){

        }

    }
}
