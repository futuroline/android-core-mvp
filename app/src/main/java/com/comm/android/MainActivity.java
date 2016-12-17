package com.comm.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.btn_login)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //获取实例
        Retrofit retrofit = new Retrofit.Builder()
                //设置OKHttpClient,如果不设置会提供一个默认的
                .client(new OkHttpClient())
                //设置baseUrl
                .baseUrl("http://dev.malalaoshi.com")
                //添加Gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        SMSParam param  = new SMSParam("send","18813023710");

//同步请求
        Call<SMSRes> call = service.login(param);
//异步请求
        call.enqueue(new Callback<SMSRes>() {
            @Override
            public void onResponse(Call<SMSRes> call, Response<SMSRes> response) {
                Log.e("SMS",response.message()) ;
                int i =0;
            }

            @Override
            public void onFailure(Call<SMSRes> call, Throwable t) {
                int i =0;
            }
        });
        call.cancel();

    }
    //定以接口
    public interface GitHubService {
        @POST("/api/v1/sms")
        Call<SMSRes> login(@Body SMSParam param);
    }
}
