package com.example.airbnbggouy.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Recherche implements Parcelable {

    String contenu;

    public String getContenu() {
        return contenu;
    }

    public Recherche(String contenu) {
        this.contenu = contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    protected Recherche(Parcel in) {
        contenu = in.readString();
    }

    public static final Creator<Recherche> CREATOR = new Creator<Recherche>() {
        @Override
        public Recherche createFromParcel(Parcel in) {
            return new Recherche(in);
        }

        @Override
        public Recherche[] newArray(int size) {
            return new Recherche[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(contenu);
    }
}
