package com.viet.rooparam.viet2.Viet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.R;

import java.util.Map;
import java.util.Set;

public class Viet_SignUp extends AppCompatActivity {

    EditText et_name, et_roll_number, et_email, et_password_one, et_password_two;
    Button btn_sign_up;
    Viet_database database;
    String name, roll, mail, password;
    BitmapFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setBackgroundDrawableResource(R.drawable.vyascollege);
        setContentView(R.layout.activity_viet__sign_up);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Bitmap bg = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.vyascollege),size.x,size.y,true);


        et_name = (EditText) findViewById(R.id.et_name);
        et_roll_number = (EditText) findViewById(R.id.et_roll_number);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password_one = (EditText) findViewById(R.id.et_password_one);
        et_password_two = (EditText) findViewById(R.id.et_password_two);
        ImageView logo = (ImageView)findViewById(R.id.image_logo);
        ImageView bg_image = (ImageView)findViewById(R.id.bg_image);
        bg_image.setImageBitmap(bg);

        btn_sign_up = (Button) findViewById(R.id.btn_signup);
        database = new Viet_database(Viet_SignUp.this);

        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.vyas_logo_circle);
        logo.setImageBitmap(bm);


        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = et_name.getText().toString();
                mail = et_email.getText().toString();
                roll = et_roll_number.getText().toString();
                password = et_password_one.getText().toString();

                if (et_name.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(Viet_SignUp.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                } else if (et_roll_number.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(Viet_SignUp.this, "Please Enter roll number", Toast.LENGTH_SHORT).show();
                } else if (et_email.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(Viet_SignUp.this, "Please Enter Email ID", Toast.LENGTH_SHORT).show();
                } else if (et_password_one.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(Viet_SignUp.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                } else if (et_password_two.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(Viet_SignUp.this, "Please Re-type Password", Toast.LENGTH_SHORT).show();
                } else if (!(et_password_one.getText().toString().equals(et_password_two.getText().toString()))) {
                    Toast.makeText(Viet_SignUp.this, "Please Enter Same Password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Viet_SignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                    database.signupData(name, roll, mail, password);

                    Intent intent = new Intent(Viet_SignUp.this, Viet_Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void login(View view) {
        Intent intent = new Intent(Viet_SignUp.this, Viet_Login.class);
        startActivity(intent);
        finish();
    }
}
