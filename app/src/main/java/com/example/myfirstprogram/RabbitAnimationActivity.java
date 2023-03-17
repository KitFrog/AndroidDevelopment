package com.example.myfirstprogram;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class RabbitAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabbit_animation);

        GifImageView gifImageView = findViewById(R.id.image_gif);
        GifDrawable gifDrawable = null;
        try {
            gifDrawable = new GifDrawable(getResources(), R.drawable.rabbit);
        } catch (Exception e) {
            e.printStackTrace();
        }

        gifImageView.setImageDrawable(gifDrawable);

    }
}