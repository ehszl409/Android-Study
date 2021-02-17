package com.example.network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.iv_1);

        // 비동기 => 자동으로 새로운 스레드가 실행된다.
        Glide
                .with(MainActivity.this) // Context
                .load("https://picsum.photos/200/300") // 네트워크 사진 URL
                .centerCrop() // 스케일 타입
                .placeholder(R.drawable.ic_launcher_background) // 사진이 없다면 띄우는 사진
                .into(iv1); // ImageView의 ID
    }
}