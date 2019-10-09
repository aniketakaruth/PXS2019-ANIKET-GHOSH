package com.example.parxsys.ui.employeelist;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.parxsys.R;
import com.example.parxsys.base.BaseFragment;
import com.example.parxsys.base.BaseViewModelProvider;
import com.example.parxsys.data.model.EmployeeData;
import com.example.parxsys.ui.employeedetails.EmployeeDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EmployeeListFragment extends BaseFragment {

    private EmployeeListViewModel mViewModel;

    @BindView(R.id.employee_list)
    Spinner employeeList;

    @BindView(R.id.submit_button)
    Button submit;

    List<EmployeeData> employeeDataList =new ArrayList<>();

    public static EmployeeListFragment newInstance() {
        return new EmployeeListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employee_list_fragment, container, false);
        unbinder = ButterKnife.bind(this,view);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = EmployeeDetailsActivity.getIntent(getContext());
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, new BaseViewModelProvider(this)).get(EmployeeListViewModel.class);
        mViewModel.getEmployee().observe(this, new Observer<List<EmployeeData>>() {
            @Override
            public void onChanged(List<EmployeeData> employeeDataList) {
                setEmployeeListData(employeeDataList);
            }
        });
        mViewModel.getEmployeeList();

    }



    public void setEmployeeListData(List<EmployeeData> employeeDataList){

        List<String> nameList = new ArrayList<>();
        for(EmployeeData item :employeeDataList) {
            nameList.add(item.getEmployeeName());
        }
        employeeList.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, nameList));
    }

}
