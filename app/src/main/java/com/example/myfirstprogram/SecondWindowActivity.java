package com.example.myfirstprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class SecondWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_window);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(16,16,16,16);
        textView.setText("Лабораторная работа № 3. Работу выполнил Попов Никита Сергеевич");

        setContentView(textView);
    }
}