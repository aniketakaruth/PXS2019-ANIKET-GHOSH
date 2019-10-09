package com.example.parxsys.ui.employeedetails;


import androidx.lifecycle.LiveData;

import com.example.parxsys.base.BaseViewModel;
import com.example.parxsys.base.LoadingElements;
import com.example.parxsys.data.model.AttendanceData;
import com.example.parxsys.data.model.EmployeeData;
import com.example.parxsys.data.repository.EmployeeDataRepository;

import java.util.List;

public class EmployeeDetailsViewModel extends BaseViewModel {


    EmployeeDataRepository employeeDataRepository;

    public EmployeeDetailsViewModel(LoadingElements loadingElements) {
        super(loadingElements);
        employeeDataRepository = new EmployeeDataRepository();
        employeeDataRepository.setLoadingElements(loadingElements);
    }

    public LiveData<List<AttendanceData>> getAttendanceData() {
        return employeeDataRepository.getAttendanceData();
    }
    public void getAttendanceList(String empId, String start, String end){
        employeeDataRepository.getEmployeeDetails(empId,start,end);
    }


}
