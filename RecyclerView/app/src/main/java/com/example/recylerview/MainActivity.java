package com.example.recylerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private RecyclerView rvUserList;
    private UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<User> users = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            users.add(new User(i, "park" + i));
        }

        // 레이아웃 매니저를 만들어준다.
        LinearLayoutManager manager =
                new LinearLayoutManager(this,
                        RecyclerView.VERTICAL,
                        false);

        rvUserList = findViewById(R.id.rv_user_list);
        // 매니저를 세팅 해준다.
        rvUserList.setLayoutManager(manager);

        userAdapter = new UserAdapter(users);
        rvUserList.setAdapter(userAdapter);

        // 스와이프 이벤트
        ItemTouchHelper.SimpleCallback simpleCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Log.d(TAG, "onSwiped: 스와이프");
                Log.d(TAG, "onSwiped: 번호" + viewHolder.getAdapterPosition());
                userAdapter.removeItem(viewHolder.getAdapterPosition());
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvUserList);
    }

}