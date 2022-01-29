package com.example.airbnbggouy.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.airbnbggouy.R;
import com.example.airbnbggouy.adapter.VilleAdapter;
import com.example.airbnbggouy.bo.Ville;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ListVille extends Fragment {


    private  String TAG = "LIST Villes";
    private String body;



    ArrayList<Ville> VilleArrayList;
    RecyclerView recyclerViewVilles;
    private VilleAdapter villeAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // eventuel viewmodel
        VilleArrayList = new ArrayList<Ville>();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return   inflater.inflate(R.layout.fragment_list_ville, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        fetchVilles();
        //
        String pointDeDebug = "debug";

    }

    public void fetchVilles(){


        Request requestVille = new Request.Builder()
                .url("https://flutter-learning.mooo.com/villes")
                // .header("Authorization","Bearer " + token )
                .build();
        //La pile est une pile de requete vers une ou n api
        OkHttpClient nouveauClient  = new OkHttpClient();
        nouveauClient.newCall(requestVille).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {

                Log.e(TAG, "failure atteindre serveur");

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response ) throws IOException {

                body = response.body().string();

                //myArray = JSON.Parse(body);
                Object myarray;
                myarray = response.body();



                Log.i(TAG , "la reponse des users: "  + body);

                // Deserialise la donnée
                try{
                    Gson mygson = new Gson();



                    VilleArrayList = mygson.fromJson(body , new TypeToken<List<Ville>>() {}.getType());

                }
                catch (Exception e){
                    Log.e(TAG, "onFailure : " + "requte messages :" + e.getMessage());

                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initialiser();
                    }
                });





            }
        });



    }

    private void initialiser() {

        villeAdapter = new VilleAdapter();
        recyclerViewVilles = getView().findViewById(R.id.RecyclerViewVilles);

        villeAdapter.setVilleArrayList(VilleArrayList);
        recyclerViewVilles.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewVilles.setAdapter(villeAdapter);

    }

}

