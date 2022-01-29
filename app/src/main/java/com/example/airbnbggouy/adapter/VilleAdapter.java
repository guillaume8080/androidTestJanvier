package com.example.airbnbggouy.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbnbggouy.R;
import com.example.airbnbggouy.bo.Ville;
import com.example.airbnbggouy.databinding.RowCityBinding;
import com.example.airbnbggouy.databinding.RowCityBindingImpl;

import java.util.ArrayList;

public class VilleAdapter extends RecyclerView.Adapter<VilleHolder> {


    //ecyclerView.Adapter<MessageHolder

    ArrayList<Ville> villeArrayList;

    public ArrayList<Ville> getVilleArrayList() {
        return villeArrayList;
    }

    public void setVilleArrayList(ArrayList<Ville> villeArrayList) {
        this.villeArrayList = villeArrayList;
    }

    @NonNull
    @Override
    public VilleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowCityBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_city,
                parent,
                false
        );


        return new VilleHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VilleHolder holder, int position) {

        Ville ville = villeArrayList.get(position);

        holder.binding.setVille(ville);

    }

    @Override
    public int getItemCount() {

        return villeArrayList.size();
    }





}
