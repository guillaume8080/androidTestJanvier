package com.example.airbnbggouy.adapter;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbnbggouy.databinding.RowCityBinding;

public class VilleHolder extends RecyclerView.ViewHolder {

    RowCityBinding binding;


    public VilleHolder(@NonNull RowCityBinding binding) {
        super(binding.getRoot());
        this.binding = binding;

    }
}

