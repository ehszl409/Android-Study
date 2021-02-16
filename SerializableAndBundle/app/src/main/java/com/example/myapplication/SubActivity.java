package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SubActivity extends AppCompatActivity {

    private Context mContext;
    private FloatingActionButton fabPop;
    private static final String TAG = "SubActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
/*
       Intent intent = getIntent();
       Bundle bundle = intent.getBundleExtra("userBundle");
       Log.d(TAG, "bundle: " + bundle.get("user"));
*/
       // Serializable
       Intent intent = getIntent();
       User user = (User) intent.getSerializableExtra("user");
       Log.d(TAG, "user: " + user);


        fabPop = findViewById(R.id.fab_pop);
        fabPop.setOnClickListener(v -> {
            Intent newintent = new Intent();
            newintent.putExtra("auth", "ok");
            setResult(1,newintent);
            finish(); //pop
        });
    }
}