package com.example.nurettinyakit.model;

import java.util.ArrayList;

/**
 * Created by nurettinyakit on 27/08/16.
 */
public class StockModel {

    private static String itemNames[] = {
            "MacBook Gold",
            "MacBook",
            "MacBook Pro",
            "MacBook Air",
            "iPhone 6",
            "iPad"
    };

    private static String itemPrices[] = {
            "2352 TL",
            "2318 TL",
            "6349 TL",
            "3475 TL",
            "2630 TL",
            "1710 TL"
    };

    private static String itemDescriptions[] = {
            "Great daily book",
            "Slimmer then ever",
            "The One and All for professionals",
            "Great for Everything",
            "Now bigger",
            "Who needs anything else.."
    };



    private static String itemUrls[] = {
            "http://images.apple.com/pr/products/images/MB12_PT_PF_Family_HERO.jpg",
            "http://images.apple.com/pr/products/images/MBPRD13_MBPRD15_Aperture_PRINT_131020_HERO.jpg",
            "http://images.apple.com/pr/products/images/MBP13_PFOP_Mavericks_131021_HERO.jpg",
            "http://images.apple.com/pr/products/images/MBA11_34L_MBA13_34R_Pages_iPhoto_HERO.jpg",
            "http://images.apple.com/pr/products/images/iPhone6s_2Up_HeroFish_PR_HERO.jpg",
            "http://images.apple.com/pr/products/images/iPadPro10_ApplePencil_SmartKeyboard_Splitview_PR_HERO.jpg"
    };

    public static ArrayList prepareData(){

        ArrayList stockList = new ArrayList<>();
        for(int i=0;i<itemNames.length;i++){
            StockItem item = new StockItem();
            item.setItemName(itemNames[i]);
            item.setItemImageUrl(itemUrls[i]);
            item.setItemPrice(itemPrices[i]);
            item.setDescription(itemDescriptions[i]);

            stockList.add(item);
        }
        return stockList;
    }

}
