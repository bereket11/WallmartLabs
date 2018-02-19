package com.example.berekethaile.wallmartlabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by berekethaile on 2/15/18.
 */

public class ProductDetails extends AppCompatActivity {

    static final int NUMBER_OF_PAGES = 100;

    private ViewPager mViewPager;
    private MyAdapter mMyAdapter;
    private List<Products> mProducts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);

        mViewPager= findViewById(R.id.pager);
        mMyAdapter = new MyAdapter(getSupportFragmentManager());

//        mViewPager.setAdapter(mMyAdapter);

        Intent intent = getIntent();
        int position = intent.getIntExtra("Item Position", 0);
        String image_url = intent.getStringExtra("Image URL");

        FragmentManager fragmentManager = getSupportFragmentManager();
        DetailsFragment fragment= new DetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("Item Position", position);
        bundle.putString("Image URL", image_url);
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().add(R.id.contaner, (Fragment) fragment).commit();
    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new DetailsFragment();
        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }
    }
}
