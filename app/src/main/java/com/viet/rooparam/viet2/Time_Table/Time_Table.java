package com.viet.rooparam.viet2.Time_Table;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.viet.rooparam.viet2.Admin.Admin_Create_Time_Table;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Adapter.ViewPagerAdapter;
import com.viet.rooparam.viet2.Student.StudentDataModel;

import java.util.ArrayList;

public class Time_Table extends AppCompatActivity {

    //Declaring variables used in this class
    TabLayout tabLayout;
    ViewPager viewPager;
    Intent intent;
    Bundle bundle = new Bundle();
    String branch, semester;
    int day;
    TextView toolbar_text;
    ArrayList<StudentDataModel> dataModels = new ArrayList<>();

    // Setting up timetable Fragments in tab layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__table);

        Toolbar toolbar_time_table = findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(toolbar_time_table);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        toolbar_text = findViewById(R.id.toolbar_title);
        toolbar_text.setText("Time Table");

        intent = getIntent();
        if (getIntent() != null) {
            branch = getIntent().getStringExtra("branch");
            semester = getIntent().getStringExtra("sem");
            day = getIntent().getExtras().getInt("day");
        }
        Log.d("branch sem time table", branch + semester);

        bundle.putString("branch", branch);
        bundle.putString("sem", semester);


        viewPager = (ViewPager) findViewById(R.id.time_table_view);
        setViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.time_table_tabs);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(day);


    }

    //Adding time-table fragments in viewpager
    public void setViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new MondayFragment(), "Monday", bundle);
        viewPagerAdapter.addFragment(new TuesdayFragment(), "Tuesday", bundle);
        viewPagerAdapter.addFragment(new WednesdayFragment(), "Wednesday", bundle);
        viewPagerAdapter.addFragment(new ThursdayFragment(), "Thursday", bundle);
        viewPagerAdapter.addFragment(new FridayFragment(), "Friday", bundle);
        viewPagerAdapter.addFragment(new SaturdayFragment(), "Saturday", bundle);
        viewPager.setAdapter(viewPagerAdapter);
    }

    //back button activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
