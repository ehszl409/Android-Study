package com.example.retrofitex01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private List<Post> posts = new ArrayList<>();

    //
    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 메인 액티비티에 연결할 인플레이터 객체 생성
        LayoutInflater inflater =
                (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 해당 리소스를 리사이클러뷰 안에 바로 붙이지 않고 객체로만 가지고 있겠다.
        View view = inflater.inflate(R.layout.post_item,parent,false);



        // view가 리스트뷰에 하나 그려짐.
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.setItem(posts.get(position));

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        // 2. user_item이 가지고 있는 위젯들을 선언
        private TextView tvTitle;
        private TextView tvId;



        // Constructor를 필수적으로 만들어 준다.
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
          tvTitle = itemView.findViewById(R.id.tv_title);
          tvId = itemView.findViewById(R.id.tv_id);

        }

        public void setItem(Post post){
            tvTitle.setText(post.getTitle());
            tvId.setText(post.getId().toString());
        }
    }

}
