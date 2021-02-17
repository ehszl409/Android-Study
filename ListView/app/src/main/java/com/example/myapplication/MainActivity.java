package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext = MainActivity.this;
    private static final String TAG = "MainActivity2";
    private ListView lvMovie;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.lv_movie);


        List<Movie> movies = new ArrayList<>();
        for (int i=0; i<20; i++){
            movies.add(new Movie(i,"제목" + i, "서브제목" + i));
        }

        ItemAdapter adapter = new ItemAdapter(movies);
        lvMovie.setAdapter(adapter);



    }
}