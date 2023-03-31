package com.example.myfirstprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.net.InetSocketAddress;

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

    public void Lab6(View view) {
        Intent intent = new Intent(this, SaveDataActivity.class);
        startActivity(intent);
    }

    public void Lab7(View view) {
        Intent intent = new Intent(this, SaveTextToFileActivity.class);
        startActivity(intent);
    }
}