package com.example.berekethaile.wallmartlabs;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by berekethaile on 2/15/18.
 */

public class DetailsFragment extends Fragment {
    private List<Products> mProducts;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    private TextView productName, productPrice, productDescription, productBrand,productColor,
    productSize;
    private ImageView productImage;
    ImagePuller pull;

    public DetailsFragment() {
        mProducts = MainActivity.mProducts;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("TOKEN MAGICO onCreate");
    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        System.out.println("TOKEN MAGICO onCreateView");
        View view = inflater.inflate(R.layout.product_details, container, false );
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        System.out.println("TOKEN MAGICO onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        int position = this.getArguments().getInt("Item Position");
        String image_url = this.getArguments().getString("Image URL");
        //Bitmap itemImage = getBitmapFromURL(image_url);
        Products product = mProducts.get(position);


        productName = view.findViewById(R.id.name);
        productPrice = view.findViewById(R.id.price);
        productDescription = view.findViewById(R.id.description);
        productBrand = view.findViewById(R.id.brand);
        productColor = view.findViewById(R.id.color);

        productSize= view.findViewById(R.id.size);
        productImage = view.findViewById(R.id.image);

        /*ImageView imageView = view.findViewById(R.id.image);

        Picasso.with(getContext()).load(image_url).into(imageView);*/

        //productImage.setImageBitmap(itemImage);
        pull = new ImagePuller(productImage);
        String[] params = {image_url};
        pull.execute(params);
        productName.setText(product.getItemName());
        String itemPrice= "Price" + " "  + "$" + "" + String.valueOf(product.getItemSale()) ;
        productPrice.setText(itemPrice);
        String itemColor= "Color:" + " " + "" + String.valueOf(product.getAttributes().getColor()) ;
        productSize.setText(product.getAttributes().getSize());
        String itemBrand= "Brand:" + " "  + "" + String.valueOf(product.getItemBrand()) ;
        productBrand.setText(itemBrand);
        productColor.setText(itemColor);
        productDescription.setText(product.getItemDesc());
    }

    public class ImagePuller extends AsyncTask<String, Void, Bitmap> {

        ImageView bindTo;

        public ImagePuller(ImageView attachTo) {
            bindTo = attachTo;
        }

        @Override
        protected Bitmap doInBackground(String... url) {
            Bitmap bitmap = null;

            try {
                URL image_url = new URL (url[0]);
                HttpsURLConnection connection = (HttpsURLConnection) image_url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            bindTo.setImageBitmap(result);
        }
    }


}
