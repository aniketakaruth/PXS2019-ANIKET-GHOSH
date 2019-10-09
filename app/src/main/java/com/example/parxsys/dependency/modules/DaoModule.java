package com.example.parxsys.dependency.modules;


import com.example.parxsys.data.dao.EmployeeDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class DaoModule {

    @Provides
    @Singleton
    public Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    public EmployeeDao provideEmployeeDao(Realm realm) {
        return new EmployeeDao(realm);
    }


}
