package com.example.airbnbggouy.bo;

public class Logement {

    int price;
    String title;
    ImageBnb illustrations;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Logement(int price, String title) {
        this.price = price;
        this.title = title;
    }

    public ImageBnb getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(ImageBnb illustrations) {
        this.illustrations = illustrations;
    }

    public Logement(int price, String title, ImageBnb illustrations) {
        this.price = price;
        this.title = title;
        this.illustrations = illustrations;
    }


}
