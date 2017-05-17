package com.w77996.histore.presenter;

import com.w77996.histore.bean.AppInfo;
import com.w77996.histore.bean.PageBean;
import com.w77996.histore.data.RecommendModel;
import com.w77996.histore.presenter.contract.RecommendContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by w77996
 * on 2017/4/20.
 * Github:https://github.com/w77996
 */
public class RecommendPresenter  implements RecommendContract.Presenter{

    private RecommendModel mModel;

    private RecommendContract.View mView;

    public RecommendPresenter(RecommendContract.View view){

        this.mView = view;

        mModel = new RecommendModel();
    }
    @Override
    public void requestDatas() {
        mView.showLodading();

        mModel.getApps(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                if(response !=null){
                    mView.showResult(response.body().getDatas());
                }
                else{
                    mView.showNodata();
                }
                mView.dimissLoading();
            }
            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.dimissLoading();
                mView.showError(t.getMessage());

            }
        });
    }
}
