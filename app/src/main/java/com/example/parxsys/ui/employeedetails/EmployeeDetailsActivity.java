package com.example.parxsys.ui.employeedetails;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.parxsys.R;
import com.example.parxsys.base.ToolbarActivity;

public class EmployeeDetailsActivity extends ToolbarActivity {


    public static Intent getIntent(Context context){
        Intent i = new Intent(context,EmployeeDetailsActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.employee_details_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, EmployeeDetailsFragment.newInstance())
                    .commitNow();
        }
    }
}
