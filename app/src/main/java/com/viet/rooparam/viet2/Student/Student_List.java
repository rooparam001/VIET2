package com.viet.rooparam.viet2.Student;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.viet.rooparam.viet2.Adapter.List_Adapter;
import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.HomePage.ProfileFragment;
import com.viet.rooparam.viet2.R;

import java.util.ArrayList;

public class Student_List extends AppCompatActivity {

    ListView student_list;

    Viet_database db;

    String roll;

    ArrayList<StudentDataModel> studentDataModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__list);

        student_list = (ListView) findViewById(R.id.student_listview);

        db = new Viet_database(Student_List.this);

        studentDataModel = db.getlist();

        List_Adapter list_adapter = new List_Adapter(getApplicationContext(), studentDataModel);
        student_list.setAdapter(list_adapter);

        student_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
    }
}
