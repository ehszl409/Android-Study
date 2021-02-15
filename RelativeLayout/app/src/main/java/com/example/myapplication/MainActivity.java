package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// 메인쓰레드 => onCreate() => UI 쓰레드,(무한루프 [A버튼, B버튼])
//                              이벤트 리스너(OS) [A버튼, B버튼]




public class MainActivity extends AppCompatActivity {

    // 로그 찍기
    private static final String TAG = "MainActivity2";

    // 전역 변수는 onDestroy() 할 때까지 남아 있다.
    private TextView tvTitle;

    // 매니페스트에서 설정된 자바 파일이 실행될 때 가장 먼저 실행되는 함수 onCreate() = main()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 그림 그리는 함수 (activity_main) => 자바로 바뀌어서 실행 된다.
        setContentView(R.layout.activity_main);

      //  tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("HI");

        Log.d(TAG, "onCreate: ");
    }

    // 앱 멈출때
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    // 앱 종료시
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    // 앱이 잠시 멈췃다가 다시 실행될 때
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    // 앱이 시작할 때
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    // 앱 그려지기 직전에
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    // 앱이 종료되도 데이터를 저장하는 방법
    // 1. 파일 (내가 가지고 있는 그림, 사진)
    // 2. 내부 DB = (Room ORM, SQLLite)
    // 3. 외부 서버 = 외부 DB (인스타그램 업로드 사진 (공유 사진))
    // 4. 하드 액세스 저장소 (제일 많이 사용) =  앱 마다 달려있다.
    //      = 실제로는 휴대폰에 하나 있다. (키로 구분 한다.) = SharedPreferences 휴대폰000000 내부 저장소
    SharedPreferences sp = getSharedPreferences("movie",MODE_PRIVATE);


}// mainActivity 종료시에 그림이 그려진다.
