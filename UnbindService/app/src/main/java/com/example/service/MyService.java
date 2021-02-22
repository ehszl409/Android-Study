package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.FileDescriptor;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private MediaPlayer mp;

   private IBinder mIBinder = new Binder();

    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");

        String musicName = intent.getStringExtra("musicName");
        Log.d(TAG, "onStartCommand: " + musicName);

        if (musicName.equals("sample1")) {
            // 객체만 만들어 줬다
            mp = MediaPlayer.create(MyService.this, R.raw.sample1);
        } else {
            mp = MediaPlayer.create(MyService.this, R.raw.sample2);
        }

        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}