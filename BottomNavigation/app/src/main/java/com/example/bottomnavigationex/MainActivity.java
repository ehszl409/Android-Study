package com.example.bottomnavigationex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bnv);






        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFrag = null;

            switch (item.getItemId()) {
                case R.id.item_person:
                    selectedFrag = new PersonFrag();
                    break;
                case R.id.item_star:
                    selectedFrag = new StarFrag();
                    break;
                case R.id.item_more:
                    selectedFrag = new MoreFrag();
                    break;
                case R.id.item_textsms:
                    selectedFrag = new TextsmsFrag();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedFrag).commit();
            return true;
        });
    }
}