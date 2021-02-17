package com.example.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView mgvMain;
    private ImageView imgMain;
    private List<Movie> movies;
    private ItemAdapter adapter;

    // 첫번째로 실행
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        // 어댑터를 전역으로 올려서 UI를 동기화 시켜 줘야 한다.
        adapter = new ItemAdapter(movies);
        mgvMain.setAdapter(adapter);

    }

    // 두 번째로 실행
    @Override
    protected void onStart() {
        super.onStart();
    }

    // 세 번째로 실행
    @Override
    protected void onResume() {
        super.onResume();
    }

    // 초기화 함수
    private void init() {
        mgvMain = findViewById(R.id.gv_main);
        movies = new ArrayList<>();
        download();
    }

    // 다운로드 함수
    private void download() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 2초간 슬립
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                movies.add(new Movie(0, "제목", R.drawable.mov01));
                movies.add(new Movie(1, "제목", R.drawable.mov02));
                movies.add(new Movie(2, "제목", R.drawable.mov03));
                movies.add(new Movie(3, "제목", R.drawable.mov04));
                movies.add(new Movie(4, "제목", R.drawable.mov05));
                movies.add(new Movie(5, "제목", R.drawable.mov06));
                movies.add(new Movie(6, "제목", R.drawable.mov07));
                movies.add(new Movie(7, "제목", R.drawable.mov08));
                movies.add(new Movie(8, "제목", R.drawable.mov09));
                movies.add(new Movie(9, "제목", R.drawable.mov10));
                movies.add(new Movie(10, "제목", R.drawable.mov11));
                movies.add(new Movie(11, "제목", R.drawable.mov12));

                // UI 스레드 (메인스레드)가 adapter.notifyDataSetChanged();을 실행해야 된다
                // UI 스레드만 그림을 그릴 수 있기 때문이다.
                // UI 스레드에게 전달하는 방법은 runOnUiThread() 함수를 호출하면 된다.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // UI를 동기화
                        adapter.notifyDataSetChanged();
                    }
                }); // end of runOnUiThread

            }
        }).start();
    }
}