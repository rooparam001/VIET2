package com.viet.rooparam.viet2.Admin;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.StudentResultActivity;
import com.viet.rooparam.viet2.Student.StudentSyllabusActivity;
import com.viet.rooparam.viet2.Viet.VietHome;


public class Admin_Acadmics_Fragemnt extends Fragment {

//    Declaring Variables
    Button attendance,result,syllabus;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        Connecting with xml components
        view = inflater.inflate(R.layout.fragment_admin_acadmics, container, false);
        attendance = view.findViewById(R.id.attendance);
        result = view.findViewById(R.id.result);
        syllabus = view.findViewById(R.id.syllabus);

//        setOnClickListener = Click event

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Admin_Attendance.class);
                startActivity(intent);

                //                Current activity to Attendance activity

            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),StudentResultActivity.class);
                startActivity(intent);

                //                Current activity to Results activity

            }
        });

        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),StudentSyllabusActivity.class);
                startActivity(intent);

                //                Current activity to Syllabus activity

            }
        });

        return view;
    }

}
