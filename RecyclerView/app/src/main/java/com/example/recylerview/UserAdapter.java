package com.example.recylerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// 3. 상속 받기
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private static final String TAG = "UserAdapter";

    // 4. 컬렉션 생성
    private final List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    // 5. addItem, removeItem
    public void addItem(User user){
        users.add(user);
        notifyDataSetChanged();
    }

    public void  removeItem(int position){
        users.remove(position);
        notifyDataSetChanged();
    }

    // 7. onCreateViewHolder (getView랑 똑같다.)
    // 차이점이 있다면 ListView는 화면에 3개가 필요하면 최초 로딩시에 3개를 그려야하니까 getView가 3번 호출됨
    // 그 다음에 스크롤을 해서 2개가 추가되야 될 때, 다시 getView를 호출 함.
    // 하지만 리사이클러뷰는 스크롤을 해서 2개가 추가되야 할 때 onBindViewHolder를 호출함.
    // onCreateViewHolder는 해당 Activity 실행시에만 호출됨.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        // 메인 액티비티에 연결할 인플레이터 객체 생성
        LayoutInflater inflater =
                (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 해당 리소스를 리사이클러뷰 안에 바로 붙이지 않고 객체로만 가지고 있겠다.
        View view = inflater.inflate(R.layout.user_item,parent,false);

        // view가 리스트뷰에 하나 그려짐.
        return new MyViewHolder(view);
    }


    // 8. onBindViewHolder
    // onCreateViewHolder로 만들어진 뷰를 재활용해서 데이터 값만 바꿔준다
    // onCreateViewHolder로 실행된 후에는 onBindViewHolder만 호출 된다.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");

        holder.setItem(users.get(position));

    }

    // 6. 컬렉션 크기 알려주기 = 화면에 몇 개 그려야될지를 알아야 하기 때문에
    @Override
    public int getItemCount() {
        return users.size();
    }

    // 리사이클러 뷰를 사용하는 순서
    // 1. ViewHolder 만들기
    // ViewHolder란 하나의 View를 가지고 있는 Holder이다.
    public class MyViewHolder extends RecyclerView.ViewHolder {

        // 2. user_item이 가지고 있는 위젯들을 선언
        private TextView tvId;
        private TextView tvUsername;


        // Constructor를 필수적으로 만들어 준다.
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvUsername = itemView.findViewById(R.id.tv_username);

            itemView.setOnClickListener(v -> {
                Log.d(TAG, "MyViewHolder: 클릭됨"+getAdapterPosition());
               // removeItem(getAdapterPosition());
            });
        }

        public void setItem(User user){
            tvId.setText(user.getId().toString());
            tvUsername.setText(user.getUsername());
        }
    }
}
