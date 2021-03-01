package com.example.mvvmtest.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmtest.model.Movie;
import com.example.mvvmtest.model.ResponseDto;
import com.example.mvvmtest.service.MovieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {

    private static final String TAG = "MovieViewModel";

    private MutableLiveData<List<Movie>> mtMovie = new MutableLiveData<>();

    public MovieViewModel() {
        List<Movie> movies = new ArrayList<>();
        mtMovie.setValue(movies);
    }

    // 구독 만들어 주기
    public MutableLiveData<List<Movie>> subscribe(){
        return mtMovie;
    }

    // 레트로핏으로 변화되는 값을 뷰에게 알림 전해 주기
    public void findAll(){
        Call<ResponseDto<List<Movie>>> call =
                MovieService.retrofit.create(MovieService.class).findAll();

        call.enqueue(new Callback<ResponseDto<List<Movie>>>() {
            @Override
            public void onResponse(Call<ResponseDto<List<Movie>>> call, Response<ResponseDto<List<Movie>>> response) {
                ResponseDto<List<Movie>> result = response.body();
                mtMovie.setValue(result.getData());
            }

            @Override
            public void onFailure(Call<ResponseDto<List<Movie>>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
