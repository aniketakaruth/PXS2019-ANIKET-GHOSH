package com.example.parxsys.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.parxsys.ui.employeedetails.EmployeeDetailsViewModel;
import com.example.parxsys.ui.employeelist.EmployeeListViewModel;


public class BaseViewModelProvider extends ViewModelProvider.NewInstanceFactory {

    private LoadingElements loadingElements;

    public BaseViewModelProvider(LoadingElements loadingElements) {
        this.loadingElements = loadingElements;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == EmployeeDetailsViewModel.class) {
            return (T) new EmployeeDetailsViewModel(loadingElements);

        }else if(modelClass == EmployeeListViewModel.class) {
            return (T) new EmployeeListViewModel(loadingElements);

        } else {

            return super.create(modelClass);
        }

    }

}
