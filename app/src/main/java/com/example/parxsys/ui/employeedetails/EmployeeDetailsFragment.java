package com.example.parxsys.ui.employeedetails;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parxsys.R;
import com.example.parxsys.base.BaseFragment;
import com.example.parxsys.base.BaseViewModelProvider;
import com.example.parxsys.data.model.AttendanceData;
import com.example.parxsys.utils.DateAndTimeUtility;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EmployeeDetailsFragment extends BaseFragment {



    @BindView(R.id.list_of_attendance)
    RecyclerView listOfAttendance;
    @BindView(R.id.hours_logged)
    TextView hoursLogged;

    @BindView(R.id.days_presents)
    TextView daysPresent;

    @BindView(R.id.days_absent)
    TextView daysAbsent;

    private EmployeeDetailsViewModel mViewModel;


    private AttendanceAdapter attendanceAdapter;


    public static EmployeeDetailsFragment newInstance() {
        return new EmployeeDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employee_details_fragment, container, false);
        unbinder = ButterKnife.bind(this,view);

        listOfAttendance.setHasFixedSize(true);
        listOfAttendance.setLayoutManager(new LinearLayoutManager(getContext()));
        attendanceAdapter = new AttendanceAdapter(getContext());
        listOfAttendance.setAdapter(attendanceAdapter);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, new BaseViewModelProvider(this)).get(EmployeeDetailsViewModel.class);

        mViewModel.getAttendanceData().observe(this, new Observer<List<AttendanceData>>() {
            @Override
            public void onChanged(List<AttendanceData> attendanceDataList) {
                setOverAllData(attendanceDataList);
                attendanceAdapter.setAttendanceDataList(attendanceDataList);
            }

        });
        mViewModel.getAttendanceList("1910","2019-08-01","2019-08-31");
        // TODO: Use the ViewModel
    }

    private void setOverAllData(List<AttendanceData> attendanceDataList) {

        Double totalHours = 0.0;
        int size=0;


        for(int i =0 ;i<attendanceDataList.size();i++) {
           totalHours += DateAndTimeUtility.getTimeDiffrenceInHours(attendanceDataList.get(i).getEntryAt(),attendanceDataList.get(i).getExitAt());
           size++;
        }

        hoursLogged.setText(String.valueOf(totalHours));
        daysPresent.setText(String.valueOf(size));
    }

}
