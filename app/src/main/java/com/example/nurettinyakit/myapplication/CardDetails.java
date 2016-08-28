package com.example.nurettinyakit.myapplication;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.nurettinyakit.model.CartModel;
import com.example.nurettinyakit.model.StockItem;
import com.example.nurettinyakit.model.StockModel;
import com.squareup.picasso.Picasso;

public class CardDetails extends AppCompatActivity {


    private StockItem stockItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

        stockItem= StockModel.getRecentItem();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView)findViewById(R.id.iv_card_detail);
        Picasso.with(this)
                .load(stockItem.getItemImageUrl())
                //.resize(30,30)
                .placeholder(R.drawable.ic_menu_send)
                .error(R.drawable.ic_menu_share)
                .into(imageView);

        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(stockItem.getItemName());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, stockItem.getItemName() + " added to your cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                CartModel.addItem(stockItem);

                    finish();

            }
        });
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

}
