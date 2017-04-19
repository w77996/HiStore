package com.w77996.histore.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.w77996.histore.ui.fragment.Categoryfragment;
import com.w77996.histore.ui.fragment.GamesFragment;
import com.w77996.histore.ui.fragment.RankingFragment;
import com.w77996.histore.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w77996
 * on 2017/4/19.
 * Github:https://github.com/w77996
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> mFragmentList = new ArrayList<>();
    private String[] mTitle = {"推荐","排行","游戏","分类"};
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }
    private void initFragment(){
        mFragmentList.add(RecommendFragment.newInstance());
        mFragmentList.add(RankingFragment.newInstance());
        mFragmentList.add(GamesFragment.newInstance());
        mFragmentList.add(Categoryfragment.newInstance());
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mFragmentList.get(position);

        return fragment;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
