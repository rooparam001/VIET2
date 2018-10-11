package com.viet.rooparam.viet2.Admin;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.viet.rooparam.viet2.Adapter.Spinner_Adapter;
import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Time_Table.Time_Table;
import com.viet.rooparam.viet2.Viet.VietHome;

public class Admin_Create_Time_Table extends AppCompatActivity {

    Button create_time_table, show_time_table;

    Spinner branch_spinner, sem_spinner, day;

    String semester_name[] = {"Select Semester", "1st Sem", "2nd Sem", "3rd Sem", "4th Sem", "5th Sem", "6th Sem", "7th Sem", "8th Sem"};
    String branch_name[] = {"Select Branch", "CSE", "ME", "CIVIL", "EE", "EC"};
    String day_name[] = {"Select Day", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    String branch, semester, str_day;

    int day_id;

    Viet_database database;

    TextView time_table_toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viet__time__table);

        Toolbar toolbar_time_table = findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(toolbar_time_table);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        time_table_toolbar = findViewById(R.id.toolbar_title);
        time_table_toolbar.setText("Time Table");

        create_time_table = (Button) findViewById(R.id.create_time_table);
        show_time_table = (Button) findViewById(R.id.show_time_table);

        branch_spinner = (Spinner) findViewById(R.id.select_branch_spinner);
        sem_spinner = (Spinner) findViewById(R.id.select_sem_spinner);
        day = (Spinner) findViewById(R.id.day_name);

        database = new Viet_database(Admin_Create_Time_Table.this);

        Spinner_Adapter spinnerAdapter = new Spinner_Adapter(getApplicationContext(), branch_name);
        branch_spinner.setAdapter(spinnerAdapter);

        Spinner_Adapter spinnerAdapter2 = new Spinner_Adapter(getApplicationContext(), semester_name);
        sem_spinner.setAdapter(spinnerAdapter2);

        Spinner_Adapter spinnerAdapter3 = new Spinner_Adapter(getApplicationContext(), day_name);
        day.setAdapter(spinnerAdapter3);

        branch_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                branch = branch_name[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sem_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semester = semester_name[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_day = day_name[position];
                day_id = position - 1;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        create_time_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (branch.equalsIgnoreCase("Select Branch")) {
                    Toast.makeText(Admin_Create_Time_Table.this, "Please select a Branch", Toast.LENGTH_SHORT).show();
                } else if (semester.equalsIgnoreCase("Select Semester")) {
                    Toast.makeText(Admin_Create_Time_Table.this, "Please select a Semester", Toast.LENGTH_SHORT).show();
                } else if (str_day.equalsIgnoreCase("Select Day")) {
                    Toast.makeText(Admin_Create_Time_Table.this, "Please select a Day", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(Admin_Create_Time_Table.this, AdminTimeTableActivity.class);
                    intent.putExtra("day", str_day);
                    intent.putExtra("branch", branch);
                    intent.putExtra("sem", semester);
                    startActivity(intent);

                }
            }
        });


        show_time_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (branch.equalsIgnoreCase("Select Branch")) {
                    Toast.makeText(Admin_Create_Time_Table.this, "Please select a Branch", Toast.LENGTH_SHORT).show();
                } else if (semester.equalsIgnoreCase("Select Semester")) {
                    Toast.makeText(Admin_Create_Time_Table.this, "Please select a Semester", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(Admin_Create_Time_Table.this, Time_Table.class);
                    intent.putExtra("branch", branch);
                    intent.putExtra("sem", semester);
                    intent.putExtra("day", day_id);
                    startActivity(intent);
                    Log.d("data in admintimetable", str_day + branch + semester);
                }
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

}
