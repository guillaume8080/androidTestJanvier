package com.example.airbnbggouy.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbnbggouy.R;
import com.example.airbnbggouy.bo.Logement;
import com.example.airbnbggouy.databinding.RowLogementsBinding;

import java.util.ArrayList;

public class LogementAdapter extends RecyclerView.Adapter<LogementHolder> {

    ArrayList<Logement> logementArrayList;





    public ArrayList<Logement> getLogementArrayList() {
        return logementArrayList;
    }

    public void setLogementArrayList(ArrayList<Logement> logementArrayList) {
        this.logementArrayList = logementArrayList;
    }

    @NonNull
    @Override
    public LogementHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLogementsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_logements,
                parent,
                false
        );
        return new LogementHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LogementHolder holder, int position) {

        Logement logement = this.logementArrayList.get(position);



        holder.binding.setLogement(logement);
    }

    @Override
    public int getItemCount() {
        return logementArrayList.size();
    }
}
