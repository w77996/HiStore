package com.w77996.histore.presenter.contract;

import com.w77996.histore.BaseView;
import com.w77996.histore.bean.AppInfo;
import com.w77996.histore.presenter.BasePresenter;

import java.util.List;

/**
 * Created by w77996
 * on 2017/4/20.
 * Github:https://github.com/w77996
 */
public interface RecommendContract  {
   public interface  View extends BaseView{
       void  showResult(List<AppInfo> datas);
       void showNodata();
       void showError(String msg);
    }
    public interface Presenter extends BasePresenter {
        void requestDatas();
    }
}
