package com.example.airbnbggouy.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbnbggouy.R;
import com.example.airbnbggouy.bo.Ville;
import com.example.airbnbggouy.databinding.RowCityBinding;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

//MainFragment
import            com.example.airbnbggouy.fragment.Main;



public class VilleAdapter extends RecyclerView.Adapter<VilleHolder> {


    //ecyclerView.Adapter<MessageHolder


    ArrayList<Ville> villeArrayList;
    String TAG  = "adapterVille";

    public ArrayList<Ville> getVilleArrayList() {
        return villeArrayList;
    }

    public void setVilleArrayList(ArrayList<Ville> villeArrayList) {
        this.villeArrayList = villeArrayList;
    }

    @NonNull
    @Override
    public VilleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ) {
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

        final Bitmap[] bitmap = new Bitmap[1];
        Ville ville = villeArrayList.get(position);
        //withPicasso( holder , ville);
        //   this.imageView.setImageBitmap(bitmap);

        new Thread(){
            public void run(){
                bitmap[0] = usingBitMap(ville, holder);
            }
        }.start();


        // TODO : setter la navigation vers la liste de logements



         holder.itemView.setOnClickListener(

                        (view)-> Navigation.findNavController(holder.itemView)
                        .navigate(R.id.fromVilleToLogements)

                );




        holder.binding.setVille(ville);
        holder.binding.imageViewCity.setImageBitmap(bitmap[0]);

    }

    @Override
    public int getItemCount() {

        return villeArrayList.size();
    }

    public void withPicasso(VilleHolder holder , Ville ville ){

        String urlBad = ville.getPic().getUrl();
        ImageView toSet = (ImageView) holder.binding.imageViewCity;
        String urlGood = "https://flutter-learning.mooo.com" + urlBad  ;
        Context context = holder.binding.getRoot().getContext();
        Picasso.with(context).load(urlGood).into(toSet);
    }

    public Bitmap usingBitMap(Ville ville , VilleHolder holder){

        Bitmap BitmapToSetHolder  = null;

        try {
            String urlBad = ville.getPic().getUrl();
            String urlGood = "https://flutter-learning.mooo.com" + urlBad  ;

            URL url = new URL(urlGood);
            


            try {
                HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                httpConn.connect();
                int resCode = httpConn.getResponseCode();
                if (resCode == HttpURLConnection.HTTP_OK) {
                    InputStream in = httpConn.getInputStream();
                       BitmapToSetHolder = BitmapFactory.decodeStream(in);

                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
             Log.e(TAG, "l url coince car: " + e.getMessage());

        }

        return BitmapToSetHolder;

    }





}
