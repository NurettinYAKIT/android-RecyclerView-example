package com.example.nurettinyakit.model;

import java.util.ArrayList;

/**
 * Created by nurettinyakit on 27/08/16.
 */
public class CartModel {

    static ArrayList<StockItem> itemsInCart;

    public static ArrayList<StockItem> getItemsInCart() {
        return itemsInCart;
    }

    public static void addItem(StockItem item){
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


    public static void removeItem(StockItem item){
        if(itemsInCart!=null&&itemsInCart.contains(item)){
            itemsInCart.remove(item);
        }
    }

    public void removeItem(String uuid){
        if(itemsInCart!=null&&uuid!=null){
            for (StockItem i:itemsInCart) {
                if(i.getUUID()==uuid){
                    itemsInCart.remove(i);
                    break;
                }
            }
        }

    }


}
