package com.w77996.histore.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.w77996.histore.R;
import com.w77996.histore.bean.AppInfo;
import com.w77996.histore.presenter.RecommendPresenter;
import com.w77996.histore.presenter.contract.RecommendContract;
import com.w77996.histore.ui.adapter.RecomendAppAdatper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.w77996.histore.decoration.DividerItemDecoration;
/**
 * Created by w77996
 * on 2017/4/19.
 * Github:https://github.com/w77996
 */
public class RecommendFragment extends Fragment implements RecommendContract.View{
    public static RecommendFragment newInstance(){
        return new RecommendFragment();
    }

    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;

    private RecomendAppAdatper mAdatper;



    private ProgressDialog mProgressDialog;

    private RecommendContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_recomend, container, false);
        ButterKnife.bind(this, view);

        mProgressDialog = new ProgressDialog(getActivity());

        mPresenter = new RecommendPresenter(this);

        initData();
        return view;


    }



    private void  initData(){

        mPresenter.requestDatas();


    }


    private void initRecycleView(List<AppInfo> datas){


        //为RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        //为RecyclerView设置分割线(这个可以对DividerItemDecoration进行修改，自定义)
        mRecyclerView.addItemDecoration(new com.w77996.histore.decoration.DividerItemDecoration(getActivity(), com.w77996.histore.decoration.DividerItemDecoration.HORIZONTAL_LIST));

        //动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        mAdatper = new RecomendAppAdatper(getActivity(),datas);

        mRecyclerView.setAdapter(mAdatper);



    }


    @Override
    public void showResult(List<AppInfo> datas) {
        initRecycleView( datas);
    }

    @Override
    public void showNodata() {

        Toast.makeText(getActivity(),"暂时无数据，请吃完饭再来",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(),"服务器开小差了："+msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLodading() {

        mProgressDialog.show();
    }

    @Override
    public void dimissLoading() {

        if(mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

}
