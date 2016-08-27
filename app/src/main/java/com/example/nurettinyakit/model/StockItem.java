package com.example.nurettinyakit.model;

/**
 * Created by nurettinyakit on 27/08/16.
 */
public class StockItem {

    private String name;
    private String imageUrl;
    private String price;
    private String description;


    public String getItemImageUrl() {
        return imageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.imageUrl = itemImageUrl;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String itemName) {
        this.name = itemName;
    }


    public void setItemPrice(String itemPrice) {
        this.price = itemPrice;
    }

    public String getItemPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
