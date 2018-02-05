package com.example.berekethaile.wallmartlabs;

import android.content.ClipData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by berekethaile on 2/1/18.
 */

public class Products {

    @SerializedName("itemId")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String itemName;

    @SerializedName("salePrice")
    @Expose
    private Integer itemSale;

    /*@SerializedName("thumbnailImage")
    @Expose
    private String itemImage;*/

    public Products(Integer id, String itemName, Integer itemSale, String itemImage) {
        this.id = id;
        this.itemName = itemName;
        this.itemSale = itemSale;
        //this.itemImage = itemImage;
    }

    public Integer getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getItemSale() {
        return itemSale;
    }

   /* public String getItemImage() {
        return itemImage;
    }*/

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemSale(Integer itemSale) {
        this.itemSale = itemSale;
    }

   /* public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }*/
}

