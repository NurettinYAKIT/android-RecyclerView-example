package com.example.nurettinyakit.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.nurettinyakit.model.CartModel;
import com.example.nurettinyakit.model.StockItem;
import com.example.nurettinyakit.model.StockModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CartListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(CartModel.getItemsInCart()));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<StockItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<StockItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cart_item_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);


            int tumbWidth = getBaseContext().getResources().getInteger(R.integer.tumbnail_width);
            int tumbHeight = getBaseContext().getResources().getInteger(R.integer.tumbnail_height);

            Picasso.with(CartListActivity.this).load(holder.mItem.getItemImageUrl()).resize(tumbWidth,tumbHeight).into(holder.mItemImage);
            holder.mNameView.setText(mValues.get(position).getItemName());
            holder.mPriceView.setText(mValues.get(position).getItemPrice());
            holder.mDescriptionView.setText(mValues.get(position).getDescription());

            holder.mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String uuid = holder.mItem.getUUID();
                    CartModel.removeItem(StockModel.getItem(uuid));

                    View recyclerView = findViewById(R.id.item_list);
                    assert recyclerView != null;
                    setupRecyclerView((RecyclerView) recyclerView);
                }
            }

            );

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.getUUID());
                        ItemDetailFragment fragment = new ItemDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.item_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, ItemDetailActivity.class);
                        intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.getUUID());

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            if(mValues==null){
                return 0;
            }
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;

            public final ImageView mItemImage;
            public final TextView mNameView;
            public final TextView mPriceView;
            public final TextView mDescriptionView;

            public StockItem mItem;
            public ImageButton mButton;

            public ViewHolder(View view) {
                super(view);
                mView = view;

                mItemImage = (ImageView) view.findViewById(R.id.iv_cart_row_image);
                mNameView = (TextView) view.findViewById(R.id.tv_cart_row_name);
                mPriceView = (TextView) view.findViewById(R.id.tv_cart_row_price);
                mDescriptionView = (TextView) view.findViewById(R.id.tv_cart_row_description);
                mButton = (ImageButton) view.findViewById(R.id.ib_cart_item_delete);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mNameView.getText() + "'";
            }

        }
    }
}
