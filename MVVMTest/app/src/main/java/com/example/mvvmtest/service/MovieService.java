package com.example.mvvmtest.service;

import com.example.mvvmtest.model.Movie;
import com.example.mvvmtest.model.ResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface MovieService {
    @GET("api/movie")
    Call<ResponseDto<List<Movie>>> findAll();

    // 192.168.0.41
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.30.1.42:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
