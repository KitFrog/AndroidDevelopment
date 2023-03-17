package com.example.myfirstprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Lab3(View view) {
        Intent intent = new Intent(this, SecondWindowActivity.class);
        startActivity(intent);
    }

    public void Lab4(View view) {
        Intent intent = new Intent(this, RabbitAnimationActivity.class);
        startActivity(intent);
    }

    public void Lab5(View view) {
        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }
}