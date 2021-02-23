package com.example.mvvmex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.mvvmex01.model.Post;
import com.example.mvvmex01.viewmodel.PostViewModel;

public class MainActivity extends AppCompatActivity {

    private PostViewModel postViewModel;
    private static final String TAG = "MainActivity2";
    private Button btnChange, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.데이터초기화();

        // 1. 레트로핏에 findAll 요청
        /*postViewModel.전체가져오기(모델);*/


        // 구독하고 있다가 데이터가 변경되면 데이터를 넘겨주기만 하면 된다.
        postViewModel.구독().observe(this,posts -> {
            Log.d(TAG, "onCreate: 데이터 변경됨");
            // 어댑터에 던지기
        });

        btnChange = findViewById(R.id.btn_change);
        btnChange.setOnClickListener(v -> {
            postViewModel.포스트한건추가(new Post(1,"제목1"));
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(v -> {
            postViewModel.포스트변경();
        });
    }
}