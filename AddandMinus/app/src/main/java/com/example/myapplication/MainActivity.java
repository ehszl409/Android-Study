package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd, btnMinus;
    private TextView tvNum;
    private Integer num;

    private static final String TAG = "MainActivity2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // xml에 있는 그림이 메모리에 올라오는 과정 = 인플레이트
        setContentView(R.layout.activity_main);

        init();
        initSetting();
        initListener();

    }

    private void init(){
        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        tvNum = findViewById(R.id.tv_num);
    }

    private void initSetting(){
        num = 1;
        tvNum.setText(num.toString());
    }

    private void initListener(){
        btnAdd.setOnClickListener(v -> {
            Log.d(TAG, "initListener: ");
            num = num + 1;
            tvNum.setText(num.toString());
        });

        btnMinus.setOnClickListener(v -> {
            Log.d(TAG, "initListener: ");
            num = num - 1;
            tvNum.setText(num.toString());
        });
    }
}