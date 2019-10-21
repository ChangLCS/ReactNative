package com.awesomeproject.module;


import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import cn.com.cfca.sdk.hke.HKEApi;
import io.reactivex.Flowable;

import com.awesomeproject.module.cfca.data.api.HKEApiWrapper;

import java.util.HashMap;
import java.util.Map;

public class CfcaModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;


    public CfcaModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "CfcaModule";
    }


    @ReactMethod
    public void requestHKEServerRandom(String name, String identityType,
                                       String identityCardNumber, String phoneNumber, String deviceID,
                                       Callback successCallback) {

        Flowable<String> ret = HKEApiWrapper.getInstance().requestHKEServerRandom(name, identityType, identityCardNumber, phoneNumber, deviceID);
        successCallback.invoke(ret);
//        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }
}