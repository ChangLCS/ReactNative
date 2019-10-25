package com.awesomeproject.module.cfca.data.api;


import java.io.IOException;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestApi {

    public static Flowable<String> getUserAutherInfoSign(String url,
                                                         String random,
                                                         String identityType,
                                                         String idNo,
                                                         String phoneNumber) {
        return Flowable.create(emitter -> {
//            String a = "1";
//            emitter.onNext(a);
//            emitter.onComplete();
            String path = url + "?random=" + random + "&idType=" + identityType + "&idNo=" + idNo + "&phoneNo=" + phoneNumber;
            OkHttpClient okHttpClient = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(path)
                    .get()//默认就是GET请求，可以不写
                    .build();
            okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String data = response.body().string();
                    emitter.onNext(data);
                    emitter.onComplete();
                }
            });


        }, BackpressureStrategy.ERROR);
    }

}
