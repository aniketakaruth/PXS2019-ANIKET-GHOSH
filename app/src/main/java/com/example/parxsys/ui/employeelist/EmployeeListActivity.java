package com.example.parxsys.ui.employeelist;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.parxsys.R;
import com.example.parxsys.base.ToolbarActivity;

public class EmployeeListActivity extends ToolbarActivity {


    public static Intent getIntent(Context context) {
        Intent i = new Intent(context,EmployeeListActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.employee_list_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, EmployeeListFragment.newInstance())
                    .commitNow();
        }
    }
}
