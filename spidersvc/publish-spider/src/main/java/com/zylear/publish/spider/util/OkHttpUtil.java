package com.zylear.publish.spider.util;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiezongyu on 2018/8/12.
 */
public class OkHttpUtil {

    public static Response syncExecJsonPost(String url, String jsonString) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        //MediaType  设置Content-Type 标头中包含的媒体类型值
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , jsonString);

        Request request = new Request.Builder()
                .url(url)//请求的url
                .post(requestBody)
                .build();

        //创建/Call
        Call call = okHttpClient.newCall(request);
        return call.execute();
    }

    //        //加入队列 异步操作
//        call.enqueue(new Callback() {
//            //请求错误回调方法
//            @Override
//            public void onFailure(Call call, IOException e) {
//                System.out.println("连接失败");
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                System.out.println(response.body().string());
//            }
//        });

}
