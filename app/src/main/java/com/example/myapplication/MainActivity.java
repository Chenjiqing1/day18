package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.myapplication.fr.AFr;
import com.example.myapplication.fr.BFr;
import com.example.myapplication.fr.CFr;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Fragment>list;
    private AFr aFr;
    private BFr bFr;
    private CFr cFr;
    private ViewPager viewpager;
    private RadioGroup radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = findViewById(R.id.viewpager);
        radio = findViewById(R.id.radio);

        aFr = new AFr();
        bFr = new BFr();
        cFr = new CFr();
        list=new ArrayList<>();
        list.add(aFr);
        list.add(bFr);
        list.add(cFr);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
switch (i){
    case 0:
        radio.check(R.id.but);
        break;
    case 1:
        radio.check(R.id.but1);
        break;
    case 2:
        radio.check(R.id.but2);
        break;
}
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
});
radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.but:
                viewpager.setCurrentItem(0);
                break;
            case R.id.but1:
                viewpager.setCurrentItem(1);
                break;
            case R.id.but2:
                viewpager.setCurrentItem(2);
                break;



        }
    }
});
    }
}
