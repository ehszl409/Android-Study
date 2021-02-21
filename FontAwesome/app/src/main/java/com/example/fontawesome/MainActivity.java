package com.example.fontawesome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import info.androidhive.fontawesome.FontDrawable;
import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1;
    private boolean isToggle = false;
    private FontTextView fontTextView;
    private FontDrawable fontDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.iv_1);
        FontDrawable drawable = new FontDrawable(this, R.string.fa_apple, false, true);
        iv1.setImageDrawable(drawable);

        iv1.setOnClickListener(v -> {
            isToggle = !isToggle;
            FontDrawable drawable1 = new FontDrawable(this, R.string.fa_apple, isToggle, true);
            iv1.setImageDrawable(drawable1);
        });
    }
}