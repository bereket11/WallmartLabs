package com.example.berekethaile.wallmartlabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by berekethaile on 2/15/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CustomViewHolder> {

    private List<Products> mProducts;

    public DataAdapter(List<Products> products) {
        this.mProducts = products;
    }

    @Override
    public DataAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Context context = holder.productImage.getContext();

        Products product = mProducts.get(position);
        Picasso.with(context).load(product.getItemImage()).into(holder.productImage);
        String itemPrice= "Price" + " "  + "$" + "" + String.valueOf(product.getItemSale()) ;
        holder.productName.setText(product.getItemName());
        holder.productPrice.setText(itemPrice);
        holder.productDescription.setText(product.getItemDesc());


    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public TextView productName, productPrice, productDescription;
        public ImageView productImage;

        public CustomViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productDescription = itemView.findViewById(R.id.product_description);
            productImage = itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Products product = mProducts.get(position);
                    String image_url = product.getItemImage();
                    Intent intent = new Intent(v.getContext(), ProductDetails.class);
                    Bundle bun = new Bundle();
                   // bun.putParcelable("prod",product);
                    intent.putExtra("Item Position", position);
                    intent.putExtra("Image URL", image_url);
                    v.getContext().startActivity(intent);

                }
            });
        }
    }
}
