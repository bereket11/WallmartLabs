package com.example.berekethaile.wallmartlabs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by berekethaile on 2/1/18.
 */

public interface ApiInterface {


    @GET("v1/paginated/items?")
    Call<Items> getProducts(@Query("format") String format, @Query("apiKey") String api_key);
}
