package com.viet.rooparam.viet2.Student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.viet.rooparam.viet2.R;

public class StudentResultActivity extends AppCompatActivity {

    WebView result_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_result);

        result_web = findViewById(R.id.result_webview);

        result_web.loadUrl("http://esuvidha.info/");


    }
}
