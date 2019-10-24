package com.awesomeproject.module;


import android.util.Log;

import com.awesomeproject.module.cfca.data.api.TestApi;
import com.awesomeproject.module.cfca.data.request.DeviceInfoRequest;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import cn.com.cfca.sdk.hke.data.AuthenticateInfo;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import com.awesomeproject.module.cfca.data.api.HKEApiWrapper;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;

import com.awesomeproject.module.cfca.data.api.DemoApi;

import java.io.IOException;

import static android.content.ContentValues.TAG;


public class CfcaModule extends ReactContextBaseJavaModule {
    private final String baseUrl = "http://192.168.4.78:8089";
    private static ReactApplicationContext reactContext;
    protected final CompositeDisposable disposables = new CompositeDisposable();
    private DemoApi demoApi;

    public CfcaModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "CfcaModule";
    }


    private Call getUserAutherInfoSign(String random, String identityType, String idNo, String phoneNumber) {
        String url = "/CFCA/getUserAutherInfoSign" + "?random=" + random + "&idType" + identityType + "&idNo" + idNo + "&phoneNo" + phoneNumber;
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        return call;
    }

    @ReactMethod
    public void requestHKEServerRandom(String name, String identityType,
                                       String identityCardNumber, String phoneNumber, String deviceID,
                                       com.facebook.react.bridge.Callback successCallback) {
        Disposable disposable = HKEApiWrapper.getInstance()
                //1
                .requestHKEServerRandom(name, identityType, identityCardNumber, phoneNumber, deviceID)
                //2
                .flatMap(serverRandom -> TestApi.getUserAutherInfoSign(baseUrl + "/CFCA/getUserAutherInfoSign", serverRandom, identityType, identityCardNumber, phoneNumber))
                //3
                .flatMap(autherInfoSign -> HKEApiWrapper.getInstance().authenticate(autherInfoSign))
                //4
                .subscribe(new Consumer<AuthenticateInfo>() {
                    @Override
                    public void accept(AuthenticateInfo info) throws Exception {
                        successCallback.invoke(info);
                    }
                });
//
//
//
//        return demoApi.registerDevice(settingSource.getRegisterEndPoint(),
//                new DeviceInfoRequest(deviceUtil.getDevice1(), deviceUtil.getDeviceType(), phone, idNo,
//                        name))
//                .map(deviceApiResult -> {
//                    if (!isEquals("0", deviceApiResult.getCode())) {
//                        throw new DemoApiException(deviceApiResult.getDesc());
//                    }
//                    userSource.saveDeviceTag(deviceApiResult.getResult());
//                    return deviceApiResult.getResult();
//                })
//                .flatMap(deviceTag -> {
//                    if (settingSource.getIsCITITest()) {
//                        return demoApi.auth(settingSource.getAuthEndPoint(), idType, idNo, phone, name,
//                                deviceTag, true).
//                                flatMap(citiEncryptedData -> HKEApiWrapper.getInstance()
//                                        .requestHKEServerRandomWithEncryptedData(citiEncryptedData.getName(),
//                                                citiEncryptedData.getIdType(), citiEncryptedData.getIdNum(),
//                                                citiEncryptedData.getPhoneNo(),
//                                                citiEncryptedData.getDeviceInfoProvidedByOrg(),
//                                                citiEncryptedData.getEncryptedSensitiveKey(),
//                                                citiEncryptedData.getAuthInfo()));
//                    } else {
//                        return demoApi.auth(settingSource.getAuthEndPoint(), idType, idNo, phone, name)
//                                .flatMap(s -> HKEApiWrapper.getInstance()
//                                        .requestHKEServerRandom(name, idType, idNo, phone, deviceTag));
//                    }
//                })
//                .flatMap(serverRandom -> demoApi.sign2(settingSource.getSignEndPoint2(), serverRandom)
//                        .subscribeOn(schedulerProvider.io()))
//                .flatMap(HKEApiWrapper.getInstance()::authenticate)
//                .map(authenticateInfo -> saveUserInfo(name, idNo, idType, phone, authenticateInfo));


//        Flowable<String> ret = HKEApiWrapper.getInstance().requestHKEServerRandom(name, identityType, identityCardNumber, phoneNumber, deviceID);
//        Disposable disposable = ret.subscribe(s -> successCallback.invoke(s));
//        disposables.add(HKEApiWrapper.getInstance().requestHKEServerRandom(name, identityType, identityCardNumber, phoneNumber, deviceID).flatMap(s ->
//                successCallback.invoke(s)
//        ));

//        Flowable<String> ret = HKEApiWrapper.getInstance().requestHKEServerRandom(name, identityType, identityCardNumber, phoneNumber, deviceID).flatMap(s -> {
//            successCallback.invoke(s);
//        });
//        Disposable disposable = ret.subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Call apiRes = getUserAutherInfoSign(s, identityType, identityCardNumber, phoneNumber);
//
//                apiRes.enqueue(new okhttp3.Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        Log.d(TAG, "onFailure: ");
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        String data = response.body().string();
//
//                        Flowable<AuthenticateInfo> authFlow = HKEApiWrapper.getInstance().authenticate(data);
//                        Disposable authDis = authFlow.subscribe(new Consumer<AuthenticateInfo>() {
//                            @Override
//                            public void accept(AuthenticateInfo auth) throws Exception {
//                                successCallback.invoke(auth.getCertificates().size());
//                            }
//                        });
//                    }
//                });
//
//            }
//        });
//        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }
}