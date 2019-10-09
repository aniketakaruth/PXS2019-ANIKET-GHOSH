package com.example.parxsys.data.local;

import android.content.Context;
import android.content.SharedPreferences;


import javax.inject.Singleton;

@Singleton
public class SharedPreferencesManager {

    private static final String FILE = "parxsys";
    private static final String EMP_ID = "empId";


    private final SharedPreferences mSharedPreferences;

    public SharedPreferencesManager(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
    }


    public String getEmpId() {
        return mSharedPreferences.getString(EMP_ID, "");
    }

    public void setEmpId(String empId) {
        mSharedPreferences.edit().putString(EMP_ID, empId).apply();
    }

}
