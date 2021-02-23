package com.example.retrofitex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private RecyclerView rvPost;
    private PostAdapter postAdapter;
    private TextView tvTittle, tvId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        download();
    }

    public void init(){
        rvPost = findViewById(R.id.rv_post);
        postAdapter = new PostAdapter();
        tvTittle = findViewById(R.id.tv_title);
        tvId = findViewById(R.id.tv_id);

        LinearLayoutManager manager =
                new LinearLayoutManager(this,
                        RecyclerView.VERTICAL,
                        false);
        rvPost.setLayoutManager(manager);
        rvPost.setAdapter(postAdapter);
    }

    public void download(){
        PostApi postApi = PostApi.retrofit.create(PostApi.class);

        Call<List<Post>> call = postApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                postAdapter.setPosts(posts);
                Log.d(TAG, "onResponse: 성공" + posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onResponse: 실패");

            }
        });
    }
}