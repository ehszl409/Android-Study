package com.example.network;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.fonts.Font;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {


    private FontTextView ftv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ftv = findViewById(R.id.ftv);

        ftv.setOnClickListener(v -> {

        });



    }
}