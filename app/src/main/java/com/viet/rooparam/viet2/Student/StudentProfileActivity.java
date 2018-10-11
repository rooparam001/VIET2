package com.viet.rooparam.viet2.Student;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.viet.rooparam.viet2.Adapter.Spinner_Adapter;
import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.HomePage.ProfileFragment;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Utility.SessionManager;
import com.viet.rooparam.viet2.Viet.VietHome;
import com.viet.rooparam.viet2.Viet.Viet_Login;

public class StudentProfileActivity extends AppCompatActivity {

    TextView toolbar_text;
    EditText name, father_name, roll, dob, mail, mobile, adr, city, pin;
    RadioGroup radioGroup;
    RadioButton male_rb, female_rb;
    Spinner branch, semester, state;

    Button submit;

    Viet_database database;

    StudentDataModel studentDataModel;

    String roll_no = "", str_branch = "", str_semester = "", str_state = "", gender = "";

    String sem[] = {"1st Sem", "2nd Sem", "3rd Sem", "4th Sem", "5th Sem", "6th Sem", "7th Sem", "8th Sem"};
    String branch_name[] = {"CSE", "ME", "CIVIL", "EE", "EC"};
    String state_name[] = {"Andhra Pradesh ", "Arunachal Pradesh", "Bihar", "Uttar Pradesh", "Haryana", "Punjab", "Rajasthan", "West Bengal",
            "Jammu and Kashmir", "Himachal Pradesh", "Uttrakhand", "Gujrat", "Madhya Pradesh", "Jharkhand", "Chhattisgarh",
            "Odisha", "Telangana", "Maharashtra", "Goa", "Karnatka", "Tamil Nadu", "Kerala", "Sikkim", "Assam", "Meghalaya",
            "Nagaland", "Manipur", "Mizoram", "Tripura"};

    TextView profile_toolbar_text;

    SessionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        Toolbar profile_bar = (Toolbar) findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(profile_bar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayOptions(R.drawable.ic_exit_to_app_black_24dp);

        profile_toolbar_text = findViewById(R.id.toolbar_title);
        profile_toolbar_text.setText("Profile");


        name = (EditText) findViewById(R.id.et_student_name);
        father_name = (EditText) findViewById(R.id.et_father_name);
        roll = (EditText) findViewById(R.id.et_roll_number);
        dob = (EditText) findViewById(R.id.et_d_o_b);
        mail = (EditText) findViewById(R.id.et_email);
        mobile = (EditText) findViewById(R.id.et_mobile_number);
        adr = (EditText) findViewById(R.id.et_address);
        city = (EditText) findViewById(R.id.et_city);
        pin = (EditText) findViewById(R.id.et_pincode);
        radioGroup = (RadioGroup) findViewById(R.id.rg_gender);
        male_rb = (RadioButton) findViewById(R.id.rb_male);
        female_rb = (RadioButton) findViewById(R.id.rb_female);
        submit = (Button) findViewById(R.id.submit_btn);


        name.setEnabled(false);
        roll.setEnabled(false);
        mail.setEnabled(false);

        branch = (Spinner) findViewById(R.id.spin_branch);
        semester = (Spinner) findViewById(R.id.spin_semester);
        state = (Spinner) findViewById(R.id.et_state);

        database = new Viet_database(StudentProfileActivity.this);

        Spinner_Adapter spinnerAdapter3 = new Spinner_Adapter(getApplicationContext(), sem);
        semester.setAdapter(spinnerAdapter3);

        Spinner_Adapter spinnerAdapter4 = new Spinner_Adapter(getApplicationContext(), branch_name);
        branch.setAdapter(spinnerAdapter4);

        Spinner_Adapter spinnerAdapter5 = new Spinner_Adapter(getApplicationContext(), state_name);
        state.setAdapter(spinnerAdapter5);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_male) {
                    gender = male_rb.getText().toString();
                } else {
                    gender = female_rb.getText().toString();
                }
            }
        });

        manager = new SessionManager(StudentProfileActivity.this);
        roll_no = manager.getData().get(SessionManager.KEY_ROLL_NUMBER);

        studentDataModel = database.getStudent(roll_no);

        name.setText(studentDataModel.student_name);
        roll.setText(studentDataModel.roll_number);
        mail.setText(studentDataModel.email);

        branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_branch = branch_name[position];
                Log.d("branch start", str_branch);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_semester = sem[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_state = state_name[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (father_name.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Enter Father Name.", Toast.LENGTH_SHORT).show();
                } else if (dob.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Enter Date Of Birth.", Toast.LENGTH_SHORT).show();
                } else if (gender.equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Select Gender.", Toast.LENGTH_SHORT).show();
                } else if (mobile.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Enter Mobile.", Toast.LENGTH_SHORT).show();
                } else if (str_branch.equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Enter Branch.", Toast.LENGTH_SHORT).show();
                } else if (str_semester.equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Enter Semester.", Toast.LENGTH_SHORT).show();
                } else if (adr.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Enter Address.", Toast.LENGTH_SHORT).show();
                } else if (str_state.equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Enter State.", Toast.LENGTH_SHORT).show();
                } else if (city.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Enter City.", Toast.LENGTH_SHORT).show();
                } else if (pin.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(StudentProfileActivity.this, "Please Enter PinCode.", Toast.LENGTH_SHORT).show();
                } else {

                    database.profileData(father_name.getText().toString(), roll_no, dob.getText().toString(), gender, mobile.getText().toString(),
                            str_branch, str_semester, adr.getText().toString(), str_state, city.getText().toString(), pin.getText().toString());

                    Intent intent = new Intent(StudentProfileActivity.this, VietHome.class);
                    intent.putExtra("roll", roll_no);
                    startActivity(intent);
                    finish();

                    Log.d("data from pifile page", father_name.getText().toString() + roll_no + dob.getText().toString() + gender + mobile.getText().toString() +
                            str_branch + str_semester + adr.getText().toString() + str_state + city.getText().toString() + pin.getText().toString());
                    Toast.makeText(StudentProfileActivity.this, "Data Saved.", Toast.LENGTH_SHORT).show();

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
