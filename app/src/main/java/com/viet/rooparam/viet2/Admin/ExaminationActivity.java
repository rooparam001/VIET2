package com.viet.rooparam.viet2.Admin;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.viet.rooparam.viet2.Adapter.NewsAdapter;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Utility.SessionManager;

public class ExaminationActivity extends AppCompatActivity {

    int[] heading = {R.string.exam_1, R.string.exam_2, R.string.exam_3, R.string.exam_4, R.string.exam_5, R.string.exam_6,
            R.string.exam_7, R.string.exam_8, R.string.exam_9, R.string.exam_10};
    int[] date = {R.string.exam_date_1, R.string.exam_date_2, R.string.exam_date_3, R.string.exam_date_4, R.string.exam_date_5,
            R.string.exam_date_6, R.string.exam_date_7, R.string.exam_date_8, R.string.exam_date_9, R.string.exam_date_10};

    NewsAdapter newsAdapter;
    TextView toolbar_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination);

        Toolbar toolbar = (Toolbar) findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText("Examination");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.exam_view);
        int col = 1;

        recyclerView.setLayoutManager(new GridLayoutManager(this, col));
        newsAdapter = new NewsAdapter(this, heading, date);
        recyclerView.setAdapter(newsAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
