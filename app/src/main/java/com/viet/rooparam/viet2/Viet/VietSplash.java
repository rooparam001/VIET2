package com.viet.rooparam.viet2.Viet;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.StudentDataModel;
import com.viet.rooparam.viet2.Student.StudentProfileActivity;
import com.viet.rooparam.viet2.Utility.SessionManager;

public class VietSplash extends AppCompatActivity {

    SessionManager manager;
    String roll_no,usertype;
    Viet_database database;
    StudentDataModel studentDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        manager = new SessionManager(VietSplash.this);
        database = new Viet_database(VietSplash.this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(manager.isLoggedIn())
                {
                    roll_no = manager.getData().get(SessionManager.KEY_ROLL_NUMBER);
                    studentDataModel = database.getStudent(roll_no);
                    usertype = studentDataModel.getUsertype();

                    if (usertype.equalsIgnoreCase("admin")) {
                        Toast.makeText(VietSplash.this, "Login Successfully As Admin", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(VietSplash.this, VietHome.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(VietSplash.this, "Welcome " + studentDataModel.getStudent_name(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(VietSplash.this, VietHome.class);
                        startActivity(intent);
                        finish();

                    }
                }
                else
                    { Intent intent = new Intent(VietSplash.this, Viet_Login.class);
                    startActivity(intent);
                    finish(); }

            }},3000);

    }
}
