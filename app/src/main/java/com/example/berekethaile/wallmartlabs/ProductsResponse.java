package com.example.berekethaile.wallmartlabs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by berekethaile on 2/5/18.
 */

public class ProductsResponse {

    @SerializedName("nextPage")
    @Expose
    private String format;

    @SerializedName("items")
    @Expose
    private List<Products> mProducts;


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format= format;
    }

    public List<Products> getProducts() {
        return mProducts;
    }

    public void setProducts(List<Products> products) {
        this.mProducts = products;
    }
}
