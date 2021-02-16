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

       /* // 트럭으로 넘어온 데이터를 받는 방법.
        Intent intent = getIntent();
        //데이터를 뿌려준다.
        String username = intent.getStringExtra("username");
        Log.d(TAG, "username: " + username);*/

       /* Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("user");*/

       Intent intent = getIntent();
       User user = (User) intent.getSerializableExtra("user");
       Log.d(TAG, "user: " + user.getUsername());

        /*String usernanme = bundle.getString("username");
        String password = bundle.getString("password");
        Log.d(TAG, "password: " + password);
        Log.d(TAG, "username: " + usernanme);
        Log.d(TAG, "bundle: " + bundle);
        Log.d(TAG, "onCreate: ");*/


        fabPop = findViewById(R.id.fab_pop);
        fabPop.setOnClickListener(v -> {
            Intent newintent = new Intent();
            newintent.putExtra("auth", "ok");
            setResult(1,newintent);
            finish(); //pop
        });
    }
}