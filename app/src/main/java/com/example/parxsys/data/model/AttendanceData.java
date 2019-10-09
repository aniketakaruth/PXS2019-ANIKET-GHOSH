package com.example.parxsys.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.realm.RealmObject;

public class AttendanceData extends RealmObject {

    @SerializedName("emp_id")
    String employeeId;

    @SerializedName("entry_at")
    String entryAt;

    @SerializedName("exit_at")
    String exitAt;

    public AttendanceData() { }

    public AttendanceData(String employeeId, String entryAt, String exitAt) {
        this.employeeId = employeeId;
        this.entryAt = entryAt;
        this.exitAt = exitAt;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEntryAt() {
        return entryAt;
    }

    public void setEntryAt(String entryAt) {
        this.entryAt = entryAt;
    }

    public String getExitAt() {
        return exitAt;
    }

    public void setExitAt(String exitAt) {
        this.exitAt = exitAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceData that = (AttendanceData) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(entryAt, that.entryAt) &&
                Objects.equals(exitAt, that.exitAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, entryAt, exitAt);
    }


    @Override
    public String toString() {
        return "AttendanceData{" +
                "employeeId='" + employeeId + '\'' +
                ", entryAt='" + entryAt + '\'' +
                ", exitAt='" + exitAt + '\'' +
                '}';
    }
}
