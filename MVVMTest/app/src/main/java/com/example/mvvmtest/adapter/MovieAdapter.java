package com.example.mvvmtest.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtest.MainActivity;
import com.example.mvvmtest.R;

import com.example.mvvmtest.model.Movie;


import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private List<Movie> movies = new ArrayList<>();

    // 컨텍스트 가지고 오기
    private final MainActivity mContext;

    public MovieAdapter(MainActivity mContext) {
        this.mContext = mContext;
    }

    // 뷰 모델의 알림을 받은 뷰의 옵저버가 변화된 데이터를 동기화 해야하는데
    // 리스트의 UI는 모두 어댑터가 관리하고 있으므로 어댑터가 옵저버 한테
    // 변화된 데이터를 전달할 수 있도록 함수를 하나 만들어 둔것이다.
    public void setMovies(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_list,parent,false);


       /* ItemListBinding itemListBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_list,
                parent,
                false
        );*/

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setItem(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class  MovieViewHolder extends RecyclerView.ViewHolder{

       private TextView tvTitle, tvContent;


        public MovieViewHolder(@NonNull View view) {
            super(view);
            /*this.itemListBinding = itemListBinding;*/

           /* LayoutInflater inflater = (LayoutInflater)
            ViewGroup view =*/

            tvTitle = view.findViewById(R.id.tv_title);
            tvContent = view.findViewById(R.id.tv_content);

            tvContent.setOnClickListener(v -> {
                // inflate ( 위치, 레이아웃, 뷰그룹)
                // 다이얼로그는 액티비티 위에 덮어 씌우서 그릴 것이기 떄문에 뷰 그룹이 null이.
                // 객체 생성
                View dialog = v.inflate(v.getContext(), R.layout.dialog_item, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(v.getContext());
                dlg.setTitle("수");
                dlg.setView(dialog);
                dlg.setPositiveButton("삭제", null);
                dlg.setNegativeButton("수정", null);
                dlg.show();
            });

        }

        public void setItem(Movie movie){
            tvTitle.setText(movie.getTitle());
            tvContent.setText(movie.getSummary());
        }


    }
}
