package com.example.parxsys.data.dao;

import com.example.parxsys.data.model.AttendanceData;
import com.example.parxsys.data.model.EmployeeData;
import com.example.parxsys.dependency.modules.DaoModule;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class EmployeeDao {

    private Realm realm;

    public EmployeeDao(Realm realm) {
        this.realm = realm;
    }

    public RealmResults<EmployeeData> getEmployeeData() {
        return realm.where(EmployeeData.class).findAllAsync();
    }


    public void persistEmployeeData(List<EmployeeData> employeeDataList) {
        List<EmployeeData> list = new ArrayList<>();
        realm.executeTransaction(realm -> {
            for (EmployeeData item : employeeDataList) {
                if (item.getEmployeeId() != null) {
                    list.add(item);
                }
            }
            realm.where(EmployeeData.class).findAll().deleteAllFromRealm();
            realm.copyToRealmOrUpdate(list);

        });
    }

    public RealmResults<AttendanceData> getAttendanceData() {
        return realm.where(AttendanceData.class).findAllAsync();
    }


    public void persistEmployeeDetailsData(List<AttendanceData> attendanceDataList) {
        realm.executeTransaction(realm -> {
            realm.where(AttendanceData.class).findAll().deleteAllFromRealm();
            realm.copyToRealmOrUpdate(attendanceDataList);

        });
    }
}
