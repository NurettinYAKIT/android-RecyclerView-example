package com.example.nurettinyakit.model;

/**
 * Created by nurettinyakit on 27/08/16.
 */
public class StockItem {

    private String UUID;

    private String name;
    private String imageUrl;
    private String price;
    private String description;
    private String category;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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
