package com.example.service2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private MediaPlayer mp;

    // IBinder는 구현해야할 메소드가 많아서 IBinder를 상속 받는 Binder로 객체를 만든다.
    private final IBinder mBinder = new LocalBinder();

    // 이렇게 만들어야지 무엇인가를 리턴 할 수 있다.
    class LocalBinder extends Binder{
        MediaPlayer getMp(){
            return mp;
        }
    }

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this,R.raw.sample2);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    // 바인드 = MainActivity에서 서비스 제어가 가능하게 하는 것.
    // IBinder를 넘겨 줘야 한다.
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}