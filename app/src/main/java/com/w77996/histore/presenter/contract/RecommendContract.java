package com.w77996.histore.presenter.contract;

import com.w77996.histore.BaseView;
import com.w77996.histore.presenter.BasePresenter;

/**
 * Created by w77996
 * on 2017/4/20.
 * Github:https://github.com/w77996
 */
public interface RecommendContract  {
    interface  View extends BaseView{

    }
    interface Presenter extends BasePresenter {
        void requestDatas();
    }
}
