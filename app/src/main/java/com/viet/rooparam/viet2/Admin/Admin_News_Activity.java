package com.viet.rooparam.viet2.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.viet.rooparam.viet2.Adapter.NewsAdapter;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Utility.SessionManager;

public class Admin_News_Activity extends AppCompatActivity {

    int[] heading = {R.string.news_heading_1, R.string.news_heading_2, R.string.news_heading_3, R.string.news_heading_4, R.string.news_heading_5, R.string.news_heading_6,
            R.string.news_heading_7, R.string.news_heading_8, R.string.news_heading_9, R.string.news_heading_10};
    int[] date = {R.string.news_heading_date_1, R.string.news_heading_date_2, R.string.news_heading_date_3, R.string.news_heading_date_4, R.string.news_heading_date_5,
            R.string.news_heading_date_6, R.string.news_heading_date_7, R.string.news_heading_date_8, R.string.news_heading_date_9, R.string.news_heading_date_10};

    NewsAdapter newsAdapter;
    TextView toolbar_title;

    SessionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_admin);

        FloatingActionButton floating_button = (FloatingActionButton) findViewById(R.id.add_news_button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText("VIET News");
        floating_button.setVisibility(View.GONE);

        manager = new SessionManager(Admin_News_Activity.this);
        if (manager.getData().get(SessionManager.KEY_USERTYPE).equalsIgnoreCase("admin")) {
            floating_button.setVisibility(View.VISIBLE);
        } else {
            floating_button.setVisibility(View.GONE);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.news_view);
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
