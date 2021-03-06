package com.pluralsight.candycoded;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class InfoActivity extends AppCompatActivity {
    private static String GEO_LOCATION_URI = "geo:0,0?q=618 E South St Orlando, FL 32801";
    private static String MAP_PACKAGE = "com.google.android.apps.maps";
    private static String PHONE_URI = "tel:0123456789";

    View phoneText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

//        phoneText = findViewById(R.id.text_view_phone);
//        phoneText.setClickable(true);
//        phoneText.setOnClickListener(this::createPhoneIntent);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);
    }

    public void createMapIntent(View view) {
        Uri addressUri = Uri.parse(GEO_LOCATION_URI);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, addressUri);
        mapIntent.setPackage(MAP_PACKAGE);

        ComponentName name = mapIntent.resolveActivity(getPackageManager());
        if (name != null) {
            startActivity(mapIntent);
        }
    }

    public void createPhoneIntent(View view) {
        Intent dial = new Intent(Intent.ACTION_DIAL);
        dial.setData(Uri.parse(PHONE_URI));
        startActivity(dial);
    }

}
