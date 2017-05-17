package com.w77996.histore.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class HttpManager {


    public OkHttpClient getOkHttpClient(){



        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

//        SSLSocketFactory sslSocketFactory = null;

        return new OkHttpClient.Builder()
//                .addInterceptor(new HeadInterceptor())
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)

                .build();


    }


    public Retrofit getRetrofit(OkHttpClient okHttpClient){


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);


        return builder.build();

    }
}
