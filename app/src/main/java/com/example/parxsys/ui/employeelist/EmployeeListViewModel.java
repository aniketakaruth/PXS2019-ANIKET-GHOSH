package com.example.parxsys.ui.employeelist;


import androidx.lifecycle.LiveData;

import com.example.parxsys.base.BaseViewModel;
import com.example.parxsys.base.LoadingElements;
import com.example.parxsys.data.model.EmployeeData;
import com.example.parxsys.data.repository.EmployeeDataRepository;

import java.util.List;

import javax.inject.Inject;

public class EmployeeListViewModel extends BaseViewModel {


//    @Inject
    private EmployeeDataRepository employeeDataRepository;

    public EmployeeListViewModel(LoadingElements loadingElements) {
        super(loadingElements);
        employeeDataRepository = new EmployeeDataRepository();
        employeeDataRepository.setLoadingElements(loadingElements);
    }

    public LiveData<List<EmployeeData>> getEmployee() {
        return employeeDataRepository.getEmployeeList();
    }
    public void getEmployeeList(){
        employeeDataRepository.getEmployeeeList();
    }
}
