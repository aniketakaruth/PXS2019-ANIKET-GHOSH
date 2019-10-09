package com.example.parxsys.ui.employeedetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parxsys.R;
import com.example.parxsys.data.model.AttendanceData;
import com.example.parxsys.utils.DateAndTimeUtility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.Viewholder> {

    Context context;
    List<AttendanceData> attendanceDataList = new ArrayList<>();

    public AttendanceAdapter(Context context) {
        this.context = context;
    }

    public void setAttendanceDataList(List<AttendanceData> attendanceDataList) {
        this.attendanceDataList =attendanceDataList;
        notifyDataSetChanged();
    }


    public int getListSize(){
        return attendanceDataList.size();
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_list_view, parent, false);
        Viewholder vh = new Viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        try {
            holder.date.setText(DateAndTimeUtility.getDate(attendanceDataList.get(position).getEntryAt()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.hours.setText(String.valueOf(DateAndTimeUtility.getTimeDiffrenceInHours(attendanceDataList.get(position).getEntryAt(),attendanceDataList.get(position).getExitAt())));

    }

    @Override
    public int getItemCount() {
        return attendanceDataList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.date_month)
        TextView date;

        @BindView(R.id.hours_logged)
        TextView hours;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
