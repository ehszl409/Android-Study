package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    private Context mContext = MainActivity.this;
    private FloatingActionButton fabRoute;
    private static final String TAG = "MainActivity2";
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // xml에 있는 그림이 메모리에 올라오는 과정 = 인플레이트
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);
        fabRoute = findViewById(R.id.fab_route);
        // 리스너가 함수를 하나만 가지고 있으면 사용 가능한 문법
        fabRoute.setOnClickListener(v -> {
            // 1. 현재 내 화면, 이동할 화면
            // 2. 현재 내 화면, 내부앱의 이동할 화면
            //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01022227777"));


            Intent intent = new Intent(mContext, SubActivity.class);
            // 트럭 속의 데이터를 넘기는 방법

            // Serializable
            User user = new User();
            user.setId(1);
            user.setUsername("park");
            user.setPassword("1234");
            intent.putExtra("user", user);

            /*// Bundle
            Bundle bundle = new Bundle();
            bundle.putSerializable("user", user);
            intent.putExtra("userBundle", bundle);*/

            startActivityForResult(intent, 300);
        });
    }

    // finish()이 후 콜백되는 함수
    // 내가 종료한 앱이 무엇인지 확인하기 위한 함수
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: 실행됨.");
        Log.d(TAG, "onActivityResult: " + requestCode);
        Log.d(TAG, "resultCode: " + resultCode);

        // Window가 무엇인지 알고 Toast와 Snackbar의 차이를 알 수 있다.
        if (requestCode == 300) { // SubActivity에서 회귀 했을경우
            if (resultCode == 1) { // 로직이 성공
                //Toast.makeText(mContext, "인증 성공함 : " +data.getStringExtra("auth"), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout, "인증성공", BaseTransientBottomBar.LENGTH_LONG).show();
            } else { // 로직 실패
                Toast.makeText(mContext, "인증 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }
}