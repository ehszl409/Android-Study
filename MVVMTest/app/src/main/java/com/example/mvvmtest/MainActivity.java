package com.example.mvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.mvvmtest.adapter.MovieAdapter;
import com.example.mvvmtest.model.Movie;
import com.example.mvvmtest.viewModel.MovieViewModel;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMovies;
    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initData();
        initObserve();
    }

    private void init(){
        rvMovies = findViewById(R.id.rv_movies);
        LinearLayoutManager manager =
                new LinearLayoutManager(this);
        rvMovies.setLayoutManager(manager);
        movieAdapter = new MovieAdapter(MainActivity.this);
        rvMovies.setAdapter(movieAdapter);
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
    }

    private void initData(){
        movieViewModel.findAll();
    }

    private void initObserve(){
        movieViewModel.subscribe().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                movieAdapter.setMovies(movies);
            }
        });
    }
}