package com.example.parxsys.dependency.modules;

import android.app.Application;
import android.content.Context;

import com.example.parxsys.dependency.scopes.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Application mApplication;

    public ContextModule(Application mApplication){
        this.mApplication = mApplication;
    }

    @ApplicationContext
    @Provides
    Context provideContext() {
        return mApplication;
    }
}
