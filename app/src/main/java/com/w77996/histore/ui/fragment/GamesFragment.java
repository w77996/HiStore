package com.w77996.histore.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.w77996.histore.R;

/**
 * Created by w77996
 * on 2017/4/19.
 * Github:https://github.com/w77996
 */
public class GamesFragment extends Fragment {
    public static GamesFragment newInstance(){
        return new GamesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_games,container,false);
        return view;


    }
}
