package com.example.nurettinyakit.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurettinyakit.model.StockItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nurettinyakit on 27/08/16.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<StockItem> data;
    private Context context;

   public DataAdapter(Context context,ArrayList<StockItem> data){
       this.data = data;
       this.context = context;
   }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Verilen parent a bagli bir view yaratir doner.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(this.context).load(data.get(position).getItemImageUrl()).resize(120,60).into(holder.ivCardImage);

        holder.tvCardName.setText(data.get(position).getItemName());
        holder.tvCardPrice.setText(data.get(position).getItemPrice());
        holder.tvCardDesctiption.setText(data.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivCardImage;
        TextView tvCardName;
        TextView tvCardPrice;
        TextView tvCardDesctiption;

        public ViewHolder(View view) {
            super(view);

            tvCardName = (TextView)view.findViewById(R.id.tv_card_name);
            ivCardImage = (ImageView)view.findViewById(R.id.iv_card_image);
            tvCardPrice = (TextView)view.findViewById(R.id.tv_card_price);
            tvCardDesctiption = (TextView)view.findViewById(R.id.tv_card_description);
        }
    }

}
