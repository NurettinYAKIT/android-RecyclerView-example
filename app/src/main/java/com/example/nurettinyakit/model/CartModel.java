package com.example.nurettinyakit.model;

import java.util.ArrayList;

/**
 * Created by nurettinyakit on 27/08/16.
 */
public class CartModel {

    ArrayList<StockItem> itemsInCart;

    public ArrayList<StockItem> getItemsInCart() {
        return itemsInCart;
    }

    public void addItem(StockItem item){
        if(itemsInCart!=null){
            itemsInCart.add(item);
        }else{
            itemsInCart = new ArrayList<>();
            itemsInCart.add(item);
        }
    }

    public void addItem(String uuid){
        if(itemsInCart!=null){
            itemsInCart.add(StockModel.getItem(uuid));
        }else{
            itemsInCart = new ArrayList<>();
            itemsInCart.add(StockModel.getItem(uuid));
        }
    }


}
