package com.viet.rooparam.viet2.Student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.viet.rooparam.viet2.R;

public class StudentSyllabusActivity extends AppCompatActivity {

    WebView syllabus_web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_syllabus);

        syllabus_web = findViewById(R.id.syllabus_webview);
        syllabus_web.loadUrl("http://www.rtu.ac.in/RTU/b-tech-2012-13");

    }
}
