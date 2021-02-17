package com.example.grid;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ItemAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies;

    public ItemAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    // 추가
    public void addItem(Movie movie){
        movies.add(movie);
    }

    // 삭제
    public void removeItem(int position){
        movies.remove(position);
    }

    // UI을 동기화 하기 위한 함수
    public void UIUpdate(){
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MainActivity mainContext = (MainActivity)parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(mainContext);

        Log.d(TAG, "getView: "+movies.get(position).getPic());

        // View는 모든 컴포넌트의 부모이다.
        View view = inflater.inflate(R.layout.activity_list_item,parent,false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        ImageView imgMain = view.findViewById(R.id.img_main);
        tvTitle.setText(movies.get(position).getTitile());
        imgMain.setImageResource(movies.get(position).getPic());
        return view;
    }
}
