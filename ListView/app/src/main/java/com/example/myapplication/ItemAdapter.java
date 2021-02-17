package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.List;

// 1. 컬렉션 정보
// 2. 화면사이즈
// 3. 아이템 사이즈
public class ItemAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies;

    public ItemAdapter(List<Movie> movies) {
        this.movies = movies;
    }


    // 아이템의 전체 크기를 확인하기 위해 필요 (어탭터와 나한테 모두 알려준다.)
    @Override
    public int getCount() {
        return movies.size();
    }

    // 클릭과 같은 이벤트가 발생시에 컬렉션 정보를 확인하기 위해 필요하다.
    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    // 잘 사용하지 않음
    @Override
    public long getItemId(int position) {
        return 0;
    }



    // 아이템의 객체를 생성해서 그림을 그리는 함수
    // 지금은 컬렉션의 크기를 보고 6개의 객체를 생성한다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d(TAG, "getView: " + position);
        if(convertView == null){
            Log.d(TAG, "null입니다.");
        } else {
            Log.d(TAG, "null이 아닙니다.");
        }

        // 부모 컨텍스트 가져오기
        // ListView를 context에 저장한다.
        // 어느 액티비티와 연결된 어탭터인지 명시하기 위해서 필요하다.
        // parent = ListView = lvMovies
        // MainActivity extends Context
        MainActivity mcontext = (MainActivity) parent.getContext();

        // 인플레이터 => 리스트 객체를 띄우기 위해 먼저 인플레이터 객체를 만들어 줍니다.
        LayoutInflater inflater = (LayoutInflater) mcontext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 스크롤 할때마다 새로운 리스트 아이템을 만들어 낸다.
        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView tvTitle =  view.findViewById(R.id.tv_title);
        TextView tvSubTitle =  view.findViewById(R.id.tv_title);
        tvTitle.setText(movies.get(position).getTitle());
        tvSubTitle.setText(movies.get(position).getTitle());

      /*  view.setOnClickListener(v -> {
            //Toast.makeText(context, "클릭됨"+ position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mcontext, DetailActivity.class);
            intent.putExtra("title", movies.get(position).getTitle());
            mcontext.startActivity(intent);
        });

        view.setOnLongClickListener(v -> {
            movies.remove(position);
            // 데이터 변경 후 UI 동기화 할려면 호출 해야하는 함수
            this.notifyDataSetChanged();
            return true;
        });
        // 인플레이터 객체를 간단하게 만드는 방법.
        //LayoutInflater inflater1 = LayoutInflater.from(context);*/

        return view;
    }
}
