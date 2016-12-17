package com.comm.android.core.network;

import com.comm.android.core.network.api.BaseApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
                           .baseUrl(BaseApi.getHost())
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

                   OkHttpClient.Builder builder = new OkHttpClient.Builder();
                   /**
                    *设置缓存，代码略
                    */

                   /**
                    *  公共参数，代码略
                    */

                   /**
                    * 设置头，代码略
                    */

                   /**
                    * Log信息拦截器，代码略
                    */

                   /**
                    * 设置cookie，代码略
                    */

                   /**
                    * 设置超时和重连，代码略
                    */
                   //以上设置结束，才能build(),不然设置白搭
                   OkHttpClient okHttpClient = builder.build();
                   mRetrofit = new Retrofit.Builder()
                           .baseUrl(BaseApi.getHost())
                           .client(okHttpClient)
                           .build();
               }
            }
        }
        return mRetrofit;
    }
}
