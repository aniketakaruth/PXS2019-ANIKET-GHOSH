package com.example.parxsys.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.realm.RealmObject;

public class EmployeeData extends RealmObject {

    @SerializedName("emp_id")
    String employeeId;


    @SerializedName("name")
    String employeeName;


    public EmployeeData() { }


    public EmployeeData(String employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeData that = (EmployeeData) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(employeeName, that.employeeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName);
    }


    @Override
    public String toString() {
        return "EmployeeData{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
