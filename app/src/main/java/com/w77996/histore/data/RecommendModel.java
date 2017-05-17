package com.w77996.histore.data;

import com.w77996.histore.bean.AppInfo;
import com.w77996.histore.bean.PageBean;
import com.w77996.histore.http.ApiService;
import com.w77996.histore.http.HttpManager;

import retrofit2.Callback;

/**
 * Created by w77996
 * on 2017/4/20.
 * Github:https://github.com/w77996
 */
public class RecommendModel {


        public void getApps (Callback<PageBean<AppInfo>> callback) {


            HttpManager manager = new HttpManager();

            ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);


            apiService.getApps("{'page':0}").enqueue(callback);


    }
}
