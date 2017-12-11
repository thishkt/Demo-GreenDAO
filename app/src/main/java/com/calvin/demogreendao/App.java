package com.calvin.demogreendao;

import android.app.Application;

public class App extends Application {

    private static App sInstance;
    private static DBHelper dbHelper;

    public static synchronized App getInstance() {
        return sInstance;
    }

    public static DBHelper getDbHelper() {
        return dbHelper;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        dbHelper = new DBHelper(this);
    }

}
