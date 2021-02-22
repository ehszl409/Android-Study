package com.example.service2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tiMusic;
    private Button btnStart;
    private Button btnEnd;
    private Button btnPause;
    private static final String TAG = "MainActivity2";
    private MediaPlayer mp;

    // 문법
    ServiceConnection connection = new ServiceConnection() {

        // 서비스가 실행되면 자동으로 콜 백된다.
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: 서비스 연결됨.");
            // 괄호를 두 번해서 다운캐스팅이 된 상태가 되야 .getMp()가 찾아 진다.
            mp = ((MyService.LocalBinder) service).getMp();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 서비스 실행 = 서비스의 onCreate와 onBind를 실행 => onServiceConnected가 실행됨
        Intent intent = new Intent(MainActivity.this, MyService.class);
        // BIND_AUTO_CREATE 서비스가 오류로 종료되면 자동으로 다시 실행한다.
        bindService(intent, connection, BIND_AUTO_CREATE);

        tiMusic = findViewById(R.id.ti_music);
        btnEnd = findViewById(R.id.btn_end);
        btnStart = findViewById(R.id.btn_start);
        btnPause = findViewById(R.id.btn_pause);

        btnStart.setOnClickListener(v -> {
            // 음악 재생
            mp.start();
        });

        btnPause.setOnClickListener(v -> {
            mp.pause();
        });

        btnEnd.setOnClickListener(v -> {
            mp.pause();
            mp.seekTo(0);
        });
    }
}