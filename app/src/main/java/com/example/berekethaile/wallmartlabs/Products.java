package com.example.berekethaile.wallmartlabs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    private Double itemSale;

    @SerializedName("brandName")
    @Expose
    private String itemBrand;

    @SerializedName("shortDescription")
    @Expose
    private String itemDesc;

    @SerializedName("attributes")
    @Expose
    private Attributes mAttributes;

    @SerializedName("thumbnailImage")
    @Expose
    private String itemImage;

    public Products(Integer id, String itemName, Double itemSale, String itemImage, String itemDesc, String itemBrand, Attributes attributes) {
        this.id = id;
        this.itemName = itemName;
        this.itemSale = itemSale;
        this.itemDesc= itemDesc;
        this.itemImage = itemImage;
        this.mAttributes = attributes;
        this.itemBrand= itemBrand;
    }

    public Integer getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Double getItemSale() {
        return itemSale;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemSale(Double itemSale) {
        this.itemSale = itemSale;
    }

    public void setAttributes(Attributes attributes) {
        mAttributes = attributes;
    }

    public Attributes getAttributes() {
        return mAttributes;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public String getItemBrand() {
        return itemBrand;
    }
}

