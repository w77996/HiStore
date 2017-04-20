package com.w77996.histore.presenter;

import com.w77996.histore.data.RecommendModel;
import com.w77996.histore.presenter.contract.RecommendContract;

/**
 * Created by w77996
 * on 2017/4/20.
 * Github:https://github.com/w77996
 */
public class RecommendPresenter  implements RecommendContract.Presenter{
    private RecommendModel mRecommendModel;
    private RecommendContract.View view;
    public RecommendPresenter(RecommendContract.View view){
        this.view = view;
    }

    @Override
    public void requestDatas() {
        mRecommendModel.getApps();
    }
}
