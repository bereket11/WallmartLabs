package com.example.berekethaile.wallmartlabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "k58636xckeqc6r28wzq963fr";
    private final String FORMAT = " json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        Call<Products> call = apiInterface.getProducts(API_KEY);

        Callback<Products> callback = getCallback();
        call.enqueue(callback);
    }

    public Callback<Products> getCallback() {
        return new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> RetrofitCall, Response<Products> response) {
                Products retrofitClient = response.body();
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {

            }
        };
    }

}
