package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private ImageView ivPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = findViewById(R.id.toolbar_main);
        ivPerson = findViewById(R.id.iv_person);

        // 오직 toolbar타입만 입력 가능하다.
       // setSupportActionBar(toolbarMain);

        ivPerson.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,PersonActivity.class);
            startActivity(intent);
        });

        toolbarMain.setOnClickListener(v -> {

        });
    }
}