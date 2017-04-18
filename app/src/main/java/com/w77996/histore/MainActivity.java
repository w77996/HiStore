package com.w77996.histore;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_drawlayout)
    DrawerLayout mDrawlayout;
    @BindView(R.id.main_nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.mian_toolbar)
    Toolbar mToolbar;

    private View mHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        // setSupportActionBar(mToolbar);
        mHeaderView = mNavigationView.getHeaderView(0);
        mToolbar.inflateMenu(R.menu.toolbar_menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawlayout,mToolbar,R.string.open,R.string.close);
        actionBarDrawerToggle.syncState();
        mDrawlayout.addDrawerListener(actionBarDrawerToggle);
    }
}
