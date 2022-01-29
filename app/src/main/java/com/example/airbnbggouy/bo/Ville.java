package com.example.airbnbggouy.bo;

import android.os.Parcelable;

public class Ville {

    String name;
    ImageBnb pic;




    public Ville(String name, ImageBnb pic) {
        this.name = name;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageBnb getPic() {
        return pic;
    }

    public void setPic(ImageBnb pic) {
        this.pic = pic;
    }

    // implementer un nveau champ qui sera chargé de transmettre l image



}
