package com.example.schoolproj.classes;

import android.graphics.Bitmap;

public class SavedItems
{
    String product_id;
    String product_name;
    float price;
    Bitmap image;
    String description;
    String store_name;
    String store_url;
    String store_location;

    public SavedItems(String product_id, String product_name, float price, String description, Bitmap image, String store_name, String store_url, String store_location)
    {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.store_name = store_name;
        this.store_url = store_url;
        this.store_location = store_location;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_url() {
        return store_url;
    }

    public void setStore_url(String store_url) {
        this.store_url = store_url;
    }

    public String getStore_location() {
        return store_location;
    }

    public void setStore_location(String store_location) {
        this.store_location = store_location;
    }



}
