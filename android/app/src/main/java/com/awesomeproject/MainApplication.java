package com.awesomeproject;

import android.app.Application;


import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

import cn.reactnative.modules.update.UpdateContext;
import cn.reactnative.modules.update.UpdatePackage;

import cn.com.cfca.sdk.hke.HKEApi;

import static com.awesomeproject.module.cfca.DemoConstants.DEMO_APP_ID;
import static com.awesomeproject.module.cfca.DemoConstants.DEMO_ORG_ID;
import static com.awesomeproject.module.cfca.DemoConstants.TEST_APP_ID;
import static com.awesomeproject.module.cfca.DemoConstants.TEST_ORG_ID;

import cn.com.cfca.sdk.hke.HKEServiceType;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        protected String getJSBundleFile() {
            return UpdateContext.getBundleUrl(MainApplication.this);
        }

        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new UpdatePackage(),
                    new CustomPackage()
            );

        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);

        HKEApi.initialize(getApplicationContext(), TEST_ORG_ID, TEST_APP_ID, HKEServiceType.TEST);
    }
}
