package com.example.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity.TAG";
    public LinearLayout firstLinearLayout;
    public LinearLayout secondLinearLayout;
    public LinearLayout threeLinearLayout;
    public LinearLayout fourLinearLayout;


    ViewPager mViewPager;
    ViewPagerFragmentAdapter mViewPagerFragmentAdapter;
    FragmentManager mFragmentManager;
    List <Fragment> mFragmentList = new ArrayList <Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        initFragmetList();
        mViewPagerFragmentAdapter = new ViewPagerFragmentAdapter(mFragmentManager, mFragmentList);
        initView();
        initViewPager();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void initViewPager() {
        mViewPager.addOnPageChangeListener(new ViewPagetOnPagerChangedLisenter());
        mViewPager.setAdapter(mViewPagerFragmentAdapter);
        mViewPager.setCurrentItem(0);
        updateBottomLinearLayoutSelect(true, false, false, false);
    }

    private void updateBottomLinearLayoutSelect(boolean f, boolean s, boolean t, boolean r) {
        firstLinearLayout.setSelected(f);
        secondLinearLayout.setSelected(s);
        threeLinearLayout.setSelected(t);
        fourLinearLayout.setSelected(r);

    }


    private void initView() {

        mViewPager = findViewById(R.id.ViewPagerLayout);
        firstLinearLayout =  findViewById(R.id.firstLinearLayout);
        firstLinearLayout.setOnClickListener(this);
        secondLinearLayout =  findViewById(R.id.secondLinearLayout);
        secondLinearLayout.setOnClickListener(this);
        threeLinearLayout =  findViewById(R.id.threeLinearLayout);
        threeLinearLayout.setOnClickListener(this);
        fourLinearLayout =  findViewById(R.id.fourLinearLayout);
        fourLinearLayout.setOnClickListener(this);

    }

    private void initFragmetList() {
        Fragment chat = new MyFragment1();
        Fragment friend = new MyFragment2();
        Fragment find = new MyFragment3();
        Fragment me = new MyFragment4();
        mFragmentList.add(chat);
        mFragmentList.add(friend);
        mFragmentList.add(find);
        mFragmentList.add(me);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.firstLinearLayout:
                mViewPager.setCurrentItem(0);
                updateBottomLinearLayoutSelect(true, false, false, false);
                break;
            case R.id.secondLinearLayout:
                mViewPager.setCurrentItem(1);
                updateBottomLinearLayoutSelect(false, true, false, false);
                break;
            case R.id.threeLinearLayout:
                mViewPager.setCurrentItem(2);
                updateBottomLinearLayoutSelect(false, false, true, false);
                break;
            case R.id.fourLinearLayout:
                mViewPager.setCurrentItem(3);
                updateBottomLinearLayoutSelect(false, false, false, true);
                break;
            default:
                break;
        }
    }


    private class ViewPagetOnPagerChangedLisenter implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.d(TAG,"onPageScrooled");
        }

        @Override
        public void onPageSelected(int position) {
            Log.d(TAG, "onPageSelected");
            boolean[] state = new boolean[4];
            state[position] = true;
            updateBottomLinearLayoutSelect(state[0], state[1], state[2],state[3]);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            Log.d(TAG, "onPageScrollStateChanged");
        }
    }
}
