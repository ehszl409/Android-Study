package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // xml에 있는 그림이 메모리에 올라오는 과정 = 인플레이트
        setContentView(R.layout.activity_main);

        // pgb_loading은 실행시에 메모리에 뜸
        // 실행전에 컴파일시에 틀이 저 친구를 R에 등록을 해 줌.
        mProgressBar = findViewById(R.id.pgb_loading);

        download();
    }

    // 3초정도 걸리기에 비동기 처리는 해준다 = 스레드를 만들어 준다.
    private void download(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                Thread.sleep(3000);
                mProgressBar.setVisibility(View.INVISIBLE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}