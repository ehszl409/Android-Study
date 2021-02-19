package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpContainer;
    private TabLayout tabs;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TabLayout은 메뉴.xml이 없음
        vpContainer = findViewById(R.id.vp_container);
        tabs = findViewById(R.id.tabs);

        // behavior는 1로 통일하자
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),1);


        myFragmentPagerAdapter.addFragment(new Frag1());
        myFragmentPagerAdapter.addFragment(new Frag2());
        myFragmentPagerAdapter.addFragment(new Frag3());

        // ViewPager와 연결
        vpContainer.setAdapter(myFragmentPagerAdapter);

        // TabLayout과 연결
        tabs.setupWithViewPager(vpContainer);

        // tab에 아이템 그리기
        tabs.getTabAt(0).setIcon(R.drawable.ic_person);
        tabs.getTabAt(1).setIcon(R.drawable.ic_favorite);
        tabs.getTabAt(2).setIcon(R.drawable.ic_android);
    }
}