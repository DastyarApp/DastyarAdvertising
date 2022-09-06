package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ir.drmazhabi.dastyaradvertisingsample.AdSize;
import ir.drmazhabi.dastyaradvertisingsample.DastyarAdView;
import ir.drmazhabi.dastyaradvertisingsample.MediumAdView;
import ir.drmazhabi.dastyaradvertisingsample.SmallAdView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmallAdView smallAdView = findViewById(R.id.smallAd);
        MediumAdView mediumAdView = findViewById(R.id.mediumAd);
        DastyarAdView.getInstance()
                .initialize(MainActivity.this)
                .loadBanner(smallAdView, AdSize.SMALL)
                .loadBanner(mediumAdView, AdSize.MEDIUM);
//                .loadFullScreenBanner();
    }
}