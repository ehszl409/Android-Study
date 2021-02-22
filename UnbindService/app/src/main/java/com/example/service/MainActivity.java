package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tiMusic;
    private Button btnStart;
    private Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiMusic = findViewById(R.id.ti_music);
        btnEnd = findViewById(R.id.btn_end);
        btnStart = findViewById(R.id.btn_start);

        // 서비스 실행 방법

        btnStart.setOnClickListener(v -> {
            String musicName = tiMusic.getText().toString();
            Intent intent = new Intent(MainActivity.this,MyService.class);
            intent.putExtra("musicName", musicName);
            startService(intent);
        });

        btnEnd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,MyService.class);
            stopService(intent);
        });
    }
}