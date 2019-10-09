package com.example.parxsys;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.example.parxsys.dependency.AppComponent;
import com.example.parxsys.dependency.DaggerAppComponent;
import com.example.parxsys.dependency.modules.ContextModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class ParxsysApplication extends MultiDexApplication {

    public static AppComponent mAppComponent;
    private static ParxsysApplication applicationInstance;



    public static ParxsysApplication get(Context context) {
        if (applicationInstance == null) {
            applicationInstance = (ParxsysApplication) context.getApplicationContext();
        }
        return applicationInstance;
    }

    public static AppComponent getmAppComponent() {
        return mAppComponent;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createAppComponent();

        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(config);


    }

    private void createAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .contextModule(new ContextModule(this))
                    .build();
        }
    }



}