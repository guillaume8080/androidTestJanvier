package com.example.airbnbggouy.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.airbnbggouy.R;
import com.example.airbnbggouy.bo.Recherche;

public class Main extends Fragment {

    private EditText editTextUsername;
    private Button monBouton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       initialize();

        monBouton.setOnClickListener(thisButton -> {

            String recherchetext = editTextUsername.getText().toString();
            // Recherche rechercheTransit = new Recherche(recherchetext);

            Bundle bundle = new Bundle();
            bundle.putString("contenuRecherche", (recherchetext));





            Navigation.findNavController(view).navigate(R.id.fromMainToLIstVille , bundle );
        });
    }

    public void initialize() {



        editTextUsername = getView().findViewById(R.id.RecherchetextField);
        monBouton = getView().findViewById(R.id.buttonSearch);


    }

}