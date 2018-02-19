package com.example.berekethaile.wallmartlabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "k58636xckeqc6r28wzq963fr";
    private final String FORMAT = "json";
    private final String ID = "12417832";

    private RecyclerView mRecyclerView;
    public static List<Products> mProducts;
    private DataAdapter mDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ApiInterface apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        Call<Items> call = apiInterface.getProducts(FORMAT, API_KEY);

        Callback<Items> callback = getCallback();
        call.enqueue(callback);
    }

    private void initViews() {

    }

    public Callback<Items> getCallback() {
        return new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> productsCall, Response<Items> response) {

                    try {
                        List<String> images = new ArrayList<>();
                        mProducts = response.body().getProducts();
                        for (int i=0; i < mProducts.size(); i++) {
                            String image_url = response.body().getProducts().get(i).getItemImage();
                            images.add(image_url);
                        }

                        mRecyclerView = findViewById(R.id.card_recycler_view);
                        mDataAdapter = new DataAdapter(mProducts);
                       // mRecyclerView.setHasFixedSize(true);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setAdapter(mDataAdapter);

                    } catch(Exception e){
                        System.out.println("TOKEN MAGICO PROBABLY, THE LIST IS EMPTY SO SOMETHING HAPPENING");
                        e.printStackTrace();
                    }
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                //System.out.println(t.);
                System.out.println("TOKEN MAGICO something Happend");
                t.printStackTrace();
            }
        };
    }

}
