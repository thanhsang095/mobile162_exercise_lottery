package com.developer.sangbarca.lotteryresult;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String urlWebservice = "http://thanhhungqb.tk:8080/kqxsmn";
    public static final ArrayList<String> arrayNameProvince = new ArrayList<>();

    TabLayout myTabLayout;
    ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Fragment_1("AG", "27-04"), "An Giang");
        adapter.AddFragment(new Fragment_1("BD", "28-04"), "Bình Dương");
        adapter.AddFragment(new Fragment_1("BL", "25-04"), "Bạc Liêu");
        adapter.AddFragment(new Fragment_1("BP", "22-04"), "Bình Phước");
        adapter.AddFragment(new Fragment_1("BTH", "27-04"), "Bình Thuận");
        adapter.AddFragment(new Fragment_1("CM", "24-04"), "Cà Mau");
        adapter.AddFragment(new Fragment_1("CT", "26-04"), "Cần Thơ");
        adapter.AddFragment(new Fragment_1("HCM", "24-04"), "Sài Gòn");

        myViewPager.setAdapter(adapter);
        myTabLayout.setupWithViewPager(myViewPager);

    }
    private void AnhXa(){
        myTabLayout = (TabLayout) findViewById(R.id.myTabLayout);
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
    }
}
