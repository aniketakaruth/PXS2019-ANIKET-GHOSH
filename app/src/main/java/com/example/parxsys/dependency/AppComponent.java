package com.example.parxsys.dependency;

import android.content.Context;

import com.example.parxsys.data.dao.EmployeeDao;
import com.example.parxsys.data.remote.EmployeeApiService;
import com.example.parxsys.data.repository.EmployeeDataRepository;
import com.example.parxsys.dependency.modules.ContextModule;
import com.example.parxsys.dependency.modules.DaoModule;
import com.example.parxsys.dependency.modules.NetworkModule;
import com.example.parxsys.dependency.modules.StorageModule;
import com.example.parxsys.dependency.scopes.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(

        modules = {
                ContextModule.class,
                NetworkModule.class,
                StorageModule.class,
                DaoModule.class
        }

)
public interface AppComponent {

    @ApplicationContext
    Context context();

    EmployeeApiService employeeApiService();

    EmployeeDao employeeDao();

    void inject(EmployeeDataRepository employeeDataRepository);
}
