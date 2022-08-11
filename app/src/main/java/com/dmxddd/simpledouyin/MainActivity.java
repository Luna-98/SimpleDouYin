package com.dmxddd.simpledouyin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String clientkey = "awki2foxqjl7e5tq"; // 需要到开发者网站申请

//        Client Key: awki2foxqjl7e5tq
//        Client Secret: 5d9a7717db46c832f161bf058f7267da
        DouYinOpenApiFactory.init(new DouYinOpenConfig(clientkey));


        DouYinOpenApi douyinOpenApi = DouYinOpenApiFactory.create(this);

        Authorization.Request request = new Authorization.Request();
        request.scope = "user_info,trial.whitelist";                          // 用户授权时必选权限
        request.state = "SDY";                                 // 用于保持请求和回调的状态，授权请求后原样带回给第三方。
        //request.callerLocalEntry = "com.xxx.xxx...activity";
        douyinOpenApi.authorize(request);
    }


}