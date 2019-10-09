package com.example.parxsys.data.remote;

import com.example.parxsys.data.model.AttendanceData;
import com.example.parxsys.data.model.EmployeeData;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface EmployeeApiService {


    @GET("http://parxsys.com/accounting/att_rprt_api.php?e76c37b493ea168cea60b8902072387caf297979")
    Observable<List<EmployeeData>> getEmployeeList();

    @Multipart
    @POST("http://parxsys.com/accounting/att_rprt_api.php?e76c37b493ea168cea60b8902072387caf297979")
    Observable<List<AttendanceData>> getAttendanceData(@Part("emp_id") RequestBody ContactId,
                                                       @Part("from_dt") RequestBody Userid,
                                                       @Part("to_dt") RequestBody EventId);


}
