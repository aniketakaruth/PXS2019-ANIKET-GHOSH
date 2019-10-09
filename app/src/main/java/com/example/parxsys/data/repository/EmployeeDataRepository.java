package com.example.parxsys.data.repository;

import androidx.lifecycle.LiveData;

import com.example.parxsys.ParxsysApplication;
import com.example.parxsys.base.BaseRepository;
import com.example.parxsys.data.dao.EmployeeDao;
import com.example.parxsys.data.model.AttendanceData;
import com.example.parxsys.data.model.EmployeeData;
import com.example.parxsys.data.remote.EmployeeApiService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;


import static com.example.parxsys.utils.RealmUtility.asLiveData;

@Singleton
public class EmployeeDataRepository extends BaseRepository {

    @Inject
    EmployeeDao employeeDao;

    @Inject
    EmployeeApiService employeeApiService;


    public EmployeeDataRepository() {
        ParxsysApplication.getmAppComponent().inject(this);
    }


    public LiveData<List<EmployeeData>> getEmployeeList() {
        return asLiveData(employeeDao.getEmployeeData());
    }

    public LiveData<List<AttendanceData>> getAttendanceData() {
        return asLiveData(employeeDao.getAttendanceData());
    }



    public void getEmployeeeList() {
        showLoading("Getting employee data");
        employeeApiService.getEmployeeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<EmployeeData>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<EmployeeData> employeeDataList) {
                        employeeDao.persistEmployeeData(employeeDataList);


                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        hideLoading();
                        showToast("Some Error Occurred");
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();

                    }
                });

    }


    public void getEmployeeDetails(String empId, String entryTime, String exitTime) {

        RequestBody employeeId = RequestBody.create(MediaType.parse("multipart/form-data"), empId);
        RequestBody from = RequestBody.create(MediaType.parse("multipart/form-data"), entryTime);
        RequestBody to = RequestBody.create(MediaType.parse("multipart/form-data"), exitTime);

        employeeApiService.getAttendanceData(employeeId,from,to)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<AttendanceData>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<AttendanceData> attendanceDataList) {
                        employeeDao.persistEmployeeDetailsData(attendanceDataList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        hideLoading();
                        showToast("Some Error Occurred");
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();

                    }
                });

    }

}
