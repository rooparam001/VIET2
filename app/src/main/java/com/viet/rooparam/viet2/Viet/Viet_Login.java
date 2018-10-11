package com.viet.rooparam.viet2.Viet;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.StudentDataModel;
import com.viet.rooparam.viet2.Student.StudentProfileActivity;
import com.viet.rooparam.viet2.Utility.SessionManager;

import java.util.ArrayList;

public class Viet_Login extends AppCompatActivity implements LifecycleObserver {

    EditText roll, password;

    CheckBox cb_keep_me_logged_in;

    Button log_in;

    String roll_no = "", usertype = "", flag,login = "";

    Viet_database database;

    StudentDataModel studentDataModel;

    SessionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.login_bg);
        setContentView(R.layout.activity_viet__login);

        database = new Viet_database(Viet_Login.this);
        manager = new SessionManager(Viet_Login.this);

        roll = (EditText) findViewById(R.id.et_name);
        password = (EditText) findViewById(R.id.et_password);

        log_in = (Button) findViewById(R.id.log_in_button);

        cb_keep_me_logged_in = findViewById(R.id.keep_me_logged_in);

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                roll_no = roll.getText().toString();

                if ((roll.getText().toString()).equalsIgnoreCase("")) {
                    Toast.makeText(Viet_Login.this, "Please enter Roll number.", Toast.LENGTH_SHORT).show();
                } else if ((roll.getText().toString()).contains(" ") || roll.getText().toString().startsWith(" ")) {
                    Toast.makeText(Viet_Login.this, "Please enter Roll number.", Toast.LENGTH_SHORT).show();
                } else if ((password.getText().toString()).equalsIgnoreCase("")) {
                    Toast.makeText(Viet_Login.this, "Please enter password.", Toast.LENGTH_SHORT).show();
                } else if (database.dataExistsOrNot(roll.getText().toString())) {
                    Toast.makeText(Viet_Login.this, "Please enter correct Roll Number.", Toast.LENGTH_SHORT).show();
                } else if (database.passwordMatchesOrNot(roll.getText().toString(), password.getText().toString())) {
                    Toast.makeText(Viet_Login.this, "Roll number and Password does not match.", Toast.LENGTH_SHORT).show();
                } else {

                    studentDataModel = database.getStudent(roll_no);
                    usertype = studentDataModel.usertype;
                    flag = database.isEmpty(roll_no);

                    if (cb_keep_me_logged_in.isChecked())
                    {
                        login = "true";
                    }

                    manager.CreateLogin(login, usertype, roll_no);

                    if (usertype.equalsIgnoreCase("admin")) {
                        Toast.makeText(Viet_Login.this, "Login Successfully As Admin", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Viet_Login.this, VietHome.class);
                        startActivity(intent);
                        finish();

                    } else {

                        if (flag.equalsIgnoreCase("true")) {
                            Toast.makeText(Viet_Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Viet_Login.this, StudentProfileActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Viet_Login.this, "Welcome " + studentDataModel.getStudent_name(), Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Viet_Login.this, VietHome.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        });
    }

    public void signup(View view) {
        Intent intent = new Intent(Viet_Login.this, Viet_SignUp.class);
        startActivity(intent);
        finish();
    }


}