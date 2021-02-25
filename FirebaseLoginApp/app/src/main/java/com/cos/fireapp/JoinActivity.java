package com.cos.fireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class JoinActivity extends AppCompatActivity {

    private static final String TAG = "JoinActivity";
    private TextInputEditText teEmail, tePassword;
    private MaterialButton btnJoin;
    private FirebaseAuth mAuth;
    private LinearLayout joinLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mAuth = FirebaseAuth.getInstance();
        teEmail = findViewById(R.id.te_email);
        tePassword = findViewById(R.id.te_password);
        joinLayout = findViewById(R.id.join_layout);
        btnJoin = findViewById(R.id.btn_join);

        btnJoin.setOnClickListener(v -> {
            // 혹시 모를 공백을 모두 날려줘야 한다.
            String email = teEmail.getText().toString().trim();
            String password = tePassword.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this,task -> {
                       if(task.isSuccessful()){
                           // 회원가입이 성공하면 바로 로그인을 해준다.
                           FirebaseUser user = mAuth.getCurrentUser();
                           Log.d(TAG, "onCreate: user" + user.getEmail());
                           Intent intent = new Intent(JoinActivity.this,HomeActivity.class);
                           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                           startActivity(intent);
                       }else{
                           Log.d(TAG, "onCreate: 로그인 실패 _ " + task.getException());
                           Snackbar.make(joinLayout,"로그인 실패",Snackbar.LENGTH_LONG).show();
                       }
                    });

        });


    }
}