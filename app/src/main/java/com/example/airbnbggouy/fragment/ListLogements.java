package com.example.airbnbggouy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.airbnbggouy.R;
import com.example.airbnbggouy.adapter.LogementAdapter;
import com.example.airbnbggouy.adapter.VilleAdapter;
import com.example.airbnbggouy.bo.Logement;
import com.example.airbnbggouy.bo.Ville;

import java.util.ArrayList;

public class ListLogements extends Fragment{

    private  String TAG = "LIST Villes";
    private String body;



    ArrayList<Logement> logementArrayList;
    RecyclerView recyclerViewLogement;
    private LogementAdapter logementAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logementArrayList = new ArrayList<Logement>();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return   inflater.inflate(R.layout.fragment_list_logements, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       fetchLogements();
    }

    public void fetchLogements(){

        Logement l1 = new Logement(225,"milles et une nuits");
        Logement l2 = new Logement(300 , "palais");
        logementArrayList.add(l1);
        logementArrayList.add(l2);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                initialiser();
            }
        });



    }
    private void initialiser(){

        logementAdapter = new LogementAdapter();
        recyclerViewLogement = getView().findViewById(R.id.RecyclerViewLogements);



        logementAdapter.setLogementArrayList(logementArrayList);
        recyclerViewLogement.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // Picasso.with(context).load(uri).into(holder.binding.imageViewCity);

        recyclerViewLogement.setAdapter(logementAdapter);

    }
}