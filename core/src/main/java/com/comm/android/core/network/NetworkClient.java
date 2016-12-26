package com.comm.android.core.network;

import com.comm.android.core.BuildConfig;
import com.comm.android.core.network.Interceptors.AuthInterceptor;
import com.comm.android.core.network.api.ApiCallback;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kang on 16/12/9.
 */

public class NetworkClient {
    private static Retrofit mRetrofit;

    public static Retrofit retrofit() {
        if (mRetrofit == null) {
            synchronized (NetworkClient.class){
               if (mRetrofit ==null){
                   /* mRetrofit = new Retrofit.Builder()
                           .baseUrl(ApiCallback.getHost())
                           .addConverterFactory(GsonConverterFactory.create())
                           .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                           .build();*/

                  /* HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                   interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                   client = new OkHttpClient.Builder()
                           .addInterceptor(interceptor)
                           .retryOnConnectionFailure(true)
                           .connectTimeout(15, TimeUnit.SECONDS)
                           .addNetworkInterceptor(authorizationInterceptor)
                           .build();

                            Retrofit mRetrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
        apiService = mRetrofit.create(ApiService.class);*/
/*
Interceptor mTokenInterceptor = new Interceptor() {
    @Override public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (Your.sToken == null || alreadyHasAuthorizationHeader(originalRequest)) {
            return chain.proceed(originalRequest);
        }
        Request authorised = originalRequest.newBuilder()
            .header("Authorization", Your.sToken)
            .build();
        return chain.proceed(authorised);
    }
};

Authenticator mAuthenticator = new Authenticator() {
    @Override public Request authenticate(Route route, Response response)
            throws IOException {
        Your.sToken = service.refreshToken();
        return response.request().newBuilder()
                       .addHeader("Authorization", Your.sToken)
                       .build();
    }
}

Retrofit mRetrofit = new Retrofit.Builder()
        .baseUrl(AppConfig.BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
service = mRetrofit.create(YourApi.class);
 */

            /*       OkHttpClient.Builder builder = new OkHttpClient.Builder();
                   *//**
                    *设置缓存，代码略
                    *//*

                   *//**
                    *  公共参数，代码略
                    *//*

                   *//**
                    * 设置头，代码略
                    *//*

                   *//**
                    * Log信息拦截器，代码略
                    *//*

                   *//**
                    * 设置cookie，代码略
                    *//*

                   *//**
                    * 设置超时和重连，代码略
                    *//*
                   //以上设置结束，才能build(),不然设置白搭
                   OkHttpClient okHttpClient = builder.build();
                   mRetrofit = new Retrofit.Builder()
                           .baseUrl(ApiCallback.getHost())
                           .client(okHttpClient)
                           .build();*/
                   AuthInterceptor authInterceptor = new AuthInterceptor();
                   OkHttpClient.Builder builder = new OkHttpClient.Builder();
                   builder.connectTimeout(30, TimeUnit.SECONDS);
                   if (BuildConfig.DEBUG){
                       //设置拦截器，以用于自定义Cookies的设置
                       builder.addNetworkInterceptor(new HttpLoggingInterceptor());
                   }
                   //增加认证拦截器
                   builder.addNetworkInterceptor(authInterceptor);
                   //设置缓存目录
                  /* File cacheDirectory = new File(context.getCacheDir()
                           .getAbsolutePath(), "HttpCache");
                   Cache cache = new Cache(cacheDirectory, 20 * 1024 * 1024);
                   builder.cache(cache);*/
                   OkHttpClient okHttpClient = builder.build();
                   //构建Retrofit
                   mRetrofit = new Retrofit.Builder()
                           //配置服务器路径
                           .baseUrl(ApiCallback.getHost())
                           //配置转化库，默认是Gson
                           .addConverterFactory(GsonConverterFactory.create())
                           //配置回调库，采用RxJava
                           .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                           //设置OKHttpClient为网络客户端
                           .client(okHttpClient)
                           .build();
               }
            }
        }
        return mRetrofit;
    }
}
