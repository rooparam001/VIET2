package com.viet.rooparam.viet2.Admin;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.viet.rooparam.viet2.Adapter.Time_Table_Listview_Adapter;
import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.StudentDataModel;

import java.util.ArrayList;

import static com.viet.rooparam.viet2.R.layout.time_table_dialoge_layout;

public class AdminTimeTableActivity extends AppCompatActivity {

    TextView show, branch_text, sem_text, day_text;
    ListView time_table_list;
    Button create_tt, submit, dismiss, from, to, time_submit;
    EditText subject, teacher, room;
    Viet_database database;
    TimePicker timePicker;

    String subject_txt = "", teacher_txt = "", room_txt = "";

    ArrayList<StudentDataModel> dataModelArrayList = null;

    Intent intent;

    String day, branch, sem, time, time_from, time_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_time_table);

        database = new Viet_database(AdminTimeTableActivity.this);

        create_tt = (Button) findViewById(R.id.create_time_table_button);
        show = (TextView) findViewById(R.id.time_table_id);
        time_table_list = (ListView) findViewById(R.id.created_time_table);
        show.setVisibility(View.GONE);

        intent = getIntent();
        if (getIntent() != null) {
            day = getIntent().getStringExtra("day");
            branch = getIntent().getStringExtra("branch");
            sem = getIntent().getStringExtra("sem");
        }

        dataModelArrayList = new ArrayList<>();

        dataModelArrayList = database.getTimetable(day, branch, sem);

        Time_Table_Listview_Adapter adapter = new Time_Table_Listview_Adapter(getApplicationContext(), dataModelArrayList);
        time_table_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        create_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(AdminTimeTableActivity.this);

                dialog.setContentView(R.layout.time_table_dialoge_layout);

                from = (Button) dialog.findViewById(R.id.from_time);
                to = (Button) dialog.findViewById(R.id.to_time);
                teacher = (EditText) dialog.findViewById(R.id.edit_teacher_dialog);
                subject = (EditText) dialog.findViewById(R.id.edit_subject_dialog);
                room = (EditText) dialog.findViewById(R.id.edit_room_no_dialog);
                submit = (Button) dialog.findViewById(R.id.submit_time_table);
                dismiss = (Button) dialog.findViewById(R.id.dismiss_button);
                day_text = (TextView) dialog.findViewById(R.id.day_name);
                branch_text = (TextView) dialog.findViewById(R.id.branch_name);
                sem_text = (TextView) dialog.findViewById(R.id.sem_name);

                day_text.setText(day);
                branch_text.setText(branch);
                sem_text.setText(sem);

                dialog.show();

                from.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Dialog timepicker_dialog = new Dialog(AdminTimeTableActivity.this);
                        timepicker_dialog.setContentView(R.layout.time_dialog_layout);
                        timePicker = (TimePicker) timepicker_dialog.findViewById(R.id.timepicker);
                        time_submit = (Button) timepicker_dialog.findViewById(R.id.time_submit);
                        timepicker_dialog.show();

                        time_submit.setOnClickListener(new View.OnClickListener() {
                            @TargetApi(Build.VERSION_CODES.M)
                            @Override
                            public void onClick(View v) {

                                int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                                if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
                                    time_from = String.valueOf(timePicker.getHour()) + ":" + String.valueOf(timePicker.getMinute());
                                    if (timePicker.getHour() <= 13) {
                                        time_from = time_from + " AM";
                                    } else {
                                        time_from = time_from + " PM";
                                    }

                                } else {
                                    time_from = String.valueOf(timePicker.getCurrentHour()) + ":" + String.valueOf(timePicker.getCurrentMinute());
                                    if (timePicker.getCurrentHour() <= 13) {
                                        time_from = time_from + " AM";
                                    } else {
                                        time_from = time_from + " PM";
                                    }
                                }

                                if (time_from.equalsIgnoreCase("")) {
                                    Toast.makeText(AdminTimeTableActivity.this, "Enter Starting Time", Toast.LENGTH_SHORT).show();
                                } else {
                                    from.setText(time_from);
                                    timepicker_dialog.dismiss();
                                }
                            }
                        });

                    }
                });

                to.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(View v) {
                        final Dialog timepicker_dialog = new Dialog(AdminTimeTableActivity.this);
                        timepicker_dialog.setContentView(R.layout.time_dialog_layout);
                        timePicker = (TimePicker) timepicker_dialog.findViewById(R.id.timepicker);
                        time_submit = (Button) timepicker_dialog.findViewById(R.id.time_submit);
                        timepicker_dialog.show();

                        time_submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                                if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
                                    time_to = String.valueOf(timePicker.getHour()) + ":" + String.valueOf(timePicker.getMinute());
                                    if (timePicker.getHour() <= 13) {
                                        time_to = time_to + " AM";
                                    } else {
                                        time_from = time_to + " PM";
                                    }
                                } else {
                                    time_to = String.valueOf(timePicker.getCurrentHour()) + ":" + String.valueOf(timePicker.getCurrentMinute());
                                    if (timePicker.getCurrentHour() <= 13) {
                                        time_to = time_to + " AM";
                                    } else {
                                        time_to = time_to + " PM";
                                    }
                                }

                                if (time_to.equalsIgnoreCase("")) {
                                    Toast.makeText(AdminTimeTableActivity.this, "Enter Ending Time", Toast.LENGTH_SHORT).show();
                                } else {
                                    to.setText(time_to);
                                    timepicker_dialog.dismiss();
                                }
                            }
                        });
                    }
                });


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        time = time_from + " - " + time_to;

                        if (time_from.equalsIgnoreCase("")) {
                            Toast.makeText(AdminTimeTableActivity.this, "Enter From Time", Toast.LENGTH_SHORT).show();
                        }else if (time_to.equalsIgnoreCase("")) {
                            Toast.makeText(AdminTimeTableActivity.this, "Enter To Time", Toast.LENGTH_SHORT).show();
                        } else if ((subject.getText().toString()).equalsIgnoreCase("")) {
                            Toast.makeText(AdminTimeTableActivity.this, "Enter Subject Name", Toast.LENGTH_SHORT).show();
                        } else if (teacher.getText().toString().equalsIgnoreCase("")) {
                            Toast.makeText(AdminTimeTableActivity.this, "Enter Teacher Name", Toast.LENGTH_SHORT).show();
                        } else if (room.getText().toString().equalsIgnoreCase("")) {
                            Toast.makeText(AdminTimeTableActivity.this, "Enter Room number", Toast.LENGTH_SHORT).show();
                        } else {

                            subject_txt = subject.getText().toString();
                            teacher_txt = teacher.getText().toString();
                            room_txt = room.getText().toString();

                            database.getTimeTableData(day, branch, sem, time, subject_txt, teacher_txt, room_txt);
                            dialog.dismiss();

                            dataModelArrayList = database.getTimetable(day, branch, sem);

                            Time_Table_Listview_Adapter adapter = new Time_Table_Listview_Adapter(getApplicationContext(), dataModelArrayList);
                            time_table_list.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        }
                    }
                });
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });

    }


}
