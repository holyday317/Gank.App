package com.kuanggang.gankapp.function.gankdetail;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseActivity;
import com.kuanggang.gankapp.widget.adapter.GankPagerAdapter;
import com.kuanggang.gankapp.widget.customview.TitleFontTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GankActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        ButterKnife.bind(this);

        initActionBar();
        initTabLayoutViewPager();
        initListener();
    }

    private void initActionBar() {
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("");
    }

    private void initTabLayoutViewPager() {
        GankPagerAdapter gankPagerAdapter = new GankPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(gankPagerAdapter);
        tablayout.setupWithViewPager(viewpager);

        // 自定义tab布局
        String[] titles = gankPagerAdapter.getTitles();
        for (int i = 0; i < titles.length; i++) {
            View tabView = View.inflate(this, R.layout.custom_tablayout_item, null);
            TitleFontTextView tv = (TitleFontTextView) tabView.findViewById(R.id.tv);
            tv.setText(titles[i]);
            if (i == 0)
                tv.setSelected(true);

            TabLayout.Tab tab = tablayout.getTabAt(i);
            tab.setCustomView(tabView);
        }
    }

    private void initListener() {
        ivMenu.setOnClickListener(this);
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.tv).setSelected(true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.tv).setSelected(false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_menu:
                drawerlayout.openDrawer(GravityCompat.START);
                break;
        }
        super.onClick(v);
    }
}
