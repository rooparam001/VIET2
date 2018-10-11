package com.viet.rooparam.viet2.Admin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.viet.rooparam.viet2.Adapter.Spinner_Adapter;
import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;
import static android.graphics.Color.colorSpace;

public class Admin_Attendance extends AppCompatActivity {

//    Variable declarations
    Button select_date, submit_attendance;
    Spinner branch_spinner, sem_spinner,subject_spinner;
    String semester_name[] = {"Select Semester", "1st Sem", "2nd Sem", "3rd Sem", "4th Sem", "5th Sem", "6th Sem", "7th Sem", "8th Sem"};
    String branch_name[] = {"Select Branch", "CSE", "ME", "CIVIL", "EE", "EC"};
    String subject_name[] = {"Select Subject", "EDC", "CN", "DSA", "TOC", "ES"};
    String chart[] = {"Present","Absent"};
    int chart_data [] = {45,5};
    Viet_database database;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_attendance);

        Toolbar toolbar_time_table = findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(toolbar_time_table);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        title = findViewById(R.id.toolbar_title);
        title.setText("Attendance");

        select_date = (Button)findViewById(R.id.select_date);
        submit_attendance = (Button)findViewById(R.id.submit_attendance);

        branch_spinner = (Spinner) findViewById(R.id.attendance_select_branch);
        sem_spinner = (Spinner) findViewById(R.id.attendance_select_sem_spinner);
        subject_spinner = (Spinner) findViewById(R.id.subject_name);

        setUpAttendanceChart();

        database = new Viet_database(Admin_Attendance.this);

        Spinner_Adapter spinnerAdapter = new Spinner_Adapter(getApplicationContext(), branch_name);
        branch_spinner.setAdapter(spinnerAdapter);

        Spinner_Adapter spinnerAdapter2 = new Spinner_Adapter(getApplicationContext(), semester_name);
        sem_spinner.setAdapter(spinnerAdapter2);

        Spinner_Adapter spinnerAdapter3 = new Spinner_Adapter(getApplicationContext(), subject_name);
        subject_spinner.setAdapter(spinnerAdapter3);

        select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(Admin_Attendance.this);
                    datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            String date = dayOfMonth + " / " + month + " / " + year;
                            select_date.setText(date);
                        }
                    });
                }

            }
        });


        submit_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog show_attendance = new Dialog(Admin_Attendance.this);
                show_attendance.setContentView(R.layout.attendance_layout);

                Button present = (Button)show_attendance.findViewById(R.id.present_button);
                Button absent = (Button)show_attendance.findViewById(R.id.absent_button);

                ProgressBar present_chart = (ProgressBar)show_attendance.findViewById(R.id.presnt_Bar);
                ProgressBar absent_chart = (ProgressBar)show_attendance.findViewById(R.id.absent_Bar);

                show_attendance.show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUpAttendanceChart()
    {
        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i= 0;i<chart.length;i++)
        {
            pieEntries.add(new PieEntry(chart_data[i], chart[i]));
        }

        List<Integer> color = new ArrayList<>();
        color.add(R.color.black);

        List<Integer> data_color = new ArrayList<>();
        data_color.add(R.color.colorPrimaryDark);
        data_color.add(R.color.black);

        PieDataSet dataSet = new PieDataSet(pieEntries,null);
        dataSet.setColors(new int[]{R.color.green,R.color.red},Admin_Attendance.this);
        dataSet.setValueTextColors(color);
        dataSet.setValueTextSize(10f);

        PieData data = new PieData(dataSet);
        data.setValueTextColors(data_color);

        PieChart teacher_chart = findViewById(R.id.teacher_pie_chart);
        PieChart student_chart = findViewById(R.id.student_pie_chart);

        teacher_chart.setData(data);
        teacher_chart.invalidate();
        teacher_chart.setHoleRadius(50f);
        teacher_chart.setDrawHoleEnabled(true);
        teacher_chart.setHoleColor(Color.WHITE);
        teacher_chart.setDescription(null);
        teacher_chart.setEntryLabelColor(R.color.colorPrimaryDark);
        teacher_chart.setEntryLabelTextSize(10f);

        student_chart.setData(data);
        student_chart.invalidate();
        student_chart.setDrawHoleEnabled(true);
        student_chart.setDescription(null);
        student_chart.setHoleRadius(50f);
        student_chart.setHoleColor(Color.WHITE);
        student_chart.setEntryLabelColor(R.color.colorPrimaryDark);
        student_chart.setEntryLabelTextSize(10f);
    }

}
