package com.viet.rooparam.viet2.Admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.TextView;

import com.viet.rooparam.viet2.Adapter.ProjectsAdapter;
import com.viet.rooparam.viet2.R;

import org.w3c.dom.Text;

public class AdminProjectsActivity extends AppCompatActivity {

    RecyclerView projects_view;

    int[] project_title = {R.string.project_title_1,R.string.project_title_2,R.string.project_title_3,R.string.project_title_4,R.string.project_title_5,
            R.string.project_title_6,R.string.project_title_7,R.string.project_title_8};
    int[] project_team = {R.string.project_team_1,R.string.project_team_2,R.string.project_team_3,R.string.project_team_4,R.string.project_team_5,
            R.string.project_team_6,R.string.project_team_7,R.string.project_team_8};
    int[] project_date = {R.string.project_date_1,R.string.project_date_2,R.string.project_date_3,R.string.project_date_4,R.string.project_date_5,
            R.string.project_date_6,R.string.project_date_7,R.string.project_date_8};

    ProjectsAdapter projectsAdapter;

    Toolbar projects_toolbar;

    TextView toolbar_projects_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_projects);

        projects_toolbar = findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(projects_toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        toolbar_projects_title = findViewById(R.id.toolbar_title);
        toolbar_projects_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_projects_title.setText("VIET Projects");

        projects_view = findViewById(R.id.projects_view);

        int column = 1;

        projects_view.setLayoutManager(new GridLayoutManager(this, column));

        projectsAdapter = new ProjectsAdapter(this, project_title, project_team,project_date);

        projects_view.setAdapter(projectsAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
