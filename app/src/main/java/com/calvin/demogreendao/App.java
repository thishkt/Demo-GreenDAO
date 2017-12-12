package com.calvin.demogreendao;

import android.app.Application;

/**
 * Created by calvin on 2017/12/12.
 */


public class App extends Application {
    private static App sInstance;

    public static synchronized App getInstance() {
        return sInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        //單例模式，存取資料庫
        DBHelper.setInstance(getApplicationContext());
    }

}
