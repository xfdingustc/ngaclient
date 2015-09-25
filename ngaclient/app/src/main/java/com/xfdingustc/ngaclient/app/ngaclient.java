package com.xfdingustc.ngaclient.app;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by Xiaofei on 2015/9/25.
 */
public class NgaClient extends Application{
    private static final String TAG = NgaClient.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initLogger();
    }

    private void initLogger() {
        Logger
            .init(TAG)
            .setMethodCount(1)
            .hideThreadInfo();
    }
}
