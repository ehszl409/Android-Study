package com.example.easysplashscreenandroiandswiperefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.opengl.EGLExt;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private SwipeRefreshLayout srl;
    private ListView lv;
    private List<Integer> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivityStart");

        srl = findViewById(R.id.srl);
        lv = findViewById(R.id.lv);
        items = new ArrayList<>();

        //초기값 설정
        items.add(10);
        items.add(20);
        items.add(30);
        items.add(40);
        items.add(50);
        items.add(60);
        items.add(70);

        final ArrayAdapter<Integer> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, items);
        lv.setAdapter(adapter);

        srl.setColorSchemeResources(R.color.black);


        // 필수적으로 리스너를 만들어 줘야 한다.
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                insertData();
                adapter.notifyDataSetChanged();
                // 새로고침 완료
                srl.setRefreshing(false);
            }
        });
    }

    public void insertData() {
        Random r = new Random();
        int ranNum = r.nextInt(100) + 1;
        items.add(ranNum);
        Collections.sort(items);
    }
}