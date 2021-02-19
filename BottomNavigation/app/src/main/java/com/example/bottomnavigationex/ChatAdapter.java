package com.example.bottomnavigationex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private final List<Chat> chats;

    public ChatAdapter(List<Chat> chats) {
        this.chats = chats;
    }

    public void addItem(Chat chat){
        chats.add(chat);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        chats.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =
                (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.chat_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.setItem(chats.get(position));
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    // 리사이클러 뷰를 사용하는 순서
    // 1. ViewHolder 만들기
    // ViewHolder란 하나의 View를 가지고 있는 Holder이다.
    public class MyViewHolder extends RecyclerView.ViewHolder {

        // 2. user_item이 가지고 있는 위젯들을 선언
        private ImageView ivProfile;
        private TextView tvUsername;
        private TextView tvMsg;
        private TextView tvInfo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvMsg = itemView.findViewById(R.id.tv_msg);
            tvInfo = itemView.findViewById(R.id.tv_info);
        }

        public void setItem(Chat chat){
            ivProfile.setImageResource(R.drawable.ic_person);
            tvUsername.setText(chat.getUsername());
            tvMsg.setText(chat.getMsg());
            tvInfo.setText(chat.getInfo());
        }


    }

}
