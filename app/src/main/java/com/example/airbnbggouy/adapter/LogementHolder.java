package com.example.airbnbggouy.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbnbggouy.databinding.RowLogementsBinding;

public class LogementHolder extends RecyclerView.ViewHolder {

    RowLogementsBinding binding;


    public LogementHolder(@NonNull RowLogementsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
