package com.viet.rooparam.viet2.Viet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.viet.rooparam.viet2.Admin.AdminPanel;
import com.viet.rooparam.viet2.Admin.Admin_Acadmics_Fragemnt;
import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.HomePage.Home;
import com.viet.rooparam.viet2.HomePage.NoticeFragment;
import com.viet.rooparam.viet2.HomePage.ProfileFragment;
import com.viet.rooparam.viet2.HomePage.AboutFragment;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.StudentDataModel;
import com.viet.rooparam.viet2.Student.button_helper;
import com.viet.rooparam.viet2.Utility.SessionManager;

public class VietHome extends AppCompatActivity {

    private TextView mTextMessage, home_txt;

    String roll = "", usertype = "", branch, sem;

    StudentDataModel dataModel;

    Intent intent;

    Viet_database database;

    SessionManager manager;

    TextView home_toolbar_title;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (usertype.equalsIgnoreCase("admin")) {
                        home_toolbar_title.setText("Admin");
                        AdminPanel adminfragment = new AdminPanel();
                        FragmentTransaction ftAdmin = getSupportFragmentManager().beginTransaction();
                        ftAdmin.replace(R.id.frame, adminfragment);
                        ftAdmin.commit();
                    } else {
                        home_toolbar_title.setText(dataModel.student_name);
                        Home fragmentOne = new Home();
                        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                        ft1.replace(R.id.frame, fragmentOne);
                        ft1.commit();
                    }
                    return true;
                case R.id.navigation_notice:
                    home_toolbar_title.setText("Notice");
                    NoticeFragment fragmentTwo = new NoticeFragment();
                    FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                    ft2.replace(R.id.frame, fragmentTwo);
                    ft2.commit();
                    return true;
                case R.id.navigation_acadmics:

                    home_toolbar_title.setText("Acadmics");
                    Admin_Acadmics_Fragemnt fragemntThree = new Admin_Acadmics_Fragemnt();
                    FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                    ft3.replace(R.id.frame, fragemntThree);
                    ft3.commit();

                    return true;
                case R.id.navigation_about:
                    home_toolbar_title.setText(R.string.about_us);
                    AboutFragment fragmentFour = new AboutFragment();
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                    ft4.replace(R.id.frame, fragmentFour);
                    ft4.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viet_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        manager = new SessionManager(VietHome.this);
        roll = manager.getData().get(SessionManager.KEY_ROLL_NUMBER);

        home_toolbar_title = findViewById(R.id.toolbar_title);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        button_helper.disableShiftMode(bottomNavigationView);

        mTextMessage = (TextView) findViewById(R.id.message);
        database = new Viet_database(VietHome.this);

        dataModel = database.getStudent(roll);

        usertype = dataModel.usertype;
        branch = dataModel.branch;
        sem = dataModel.semester;

        home_toolbar_title.setText(dataModel.student_name);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (usertype.equalsIgnoreCase("admin")) {
            AdminPanel adminfragment = new AdminPanel();
            FragmentTransaction ftAdmin = getSupportFragmentManager().beginTransaction();
            ftAdmin.replace(R.id.frame, adminfragment);
            ftAdmin.commit();

            home_toolbar_title.setText("Admin");
        } else {

            Home fragmentOne = new Home();
            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
            ft1.replace(R.id.frame, fragmentOne);
            ft1.commit();

            home_toolbar_title.setText(dataModel.student_name);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.viet_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile_menu_item:

                Bundle args = new Bundle();
                args.putString("roll", roll);

                home_toolbar_title.setText("Profile");
                ProfileFragment fragmentFour = new ProfileFragment();
                fragmentFour.setArguments(args);

                FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                ft4.replace(R.id.frame, fragmentFour);
                ft4.commit();

                return true;

            case R.id.sign_out_menu_item:
                String login = "false";
                manager.LogOut(login);
                Intent intent = new Intent(VietHome.this, Viet_Login.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}