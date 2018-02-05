package com.example.berekethaile.wallmartlabs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by berekethaile on 2/1/18.
 */

public class RetrofitClient {

    private static final String BASE_URL = "http://api.walmartlabs.com/";
    private static Retrofit sRetrofit = null;

    public static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
