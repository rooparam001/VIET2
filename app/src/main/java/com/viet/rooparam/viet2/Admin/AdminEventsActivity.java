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

import com.viet.rooparam.viet2.Adapter.EventsAdapter;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Utility.SessionManager;

public class AdminEventsActivity extends AppCompatActivity {

    int images[] = {R.drawable.event_one, R.drawable.event_two, R.drawable.event_three, R.drawable.event_four, R.drawable.event_five,
            R.drawable.event_six, R.drawable.event_seven};

    EventsAdapter eventsAdapter;

    TextView toolbar_events_title;

    Toolbar events_toolbar;

    SessionManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_events);

        FloatingActionButton floating_button = (FloatingActionButton) findViewById(R.id.add_events_button);
        events_toolbar = findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(events_toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        toolbar_events_title = findViewById(R.id.toolbar_title);
        toolbar_events_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_events_title.setText("VIET Events");

        floating_button.setVisibility(View.GONE);

        manager = new SessionManager(AdminEventsActivity.this);
        if (manager.getData().get(SessionManager.KEY_USERTYPE).equalsIgnoreCase("admin")) {
            floating_button.setVisibility(View.VISIBLE);
        } else {
            floating_button.setVisibility(View.GONE);
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.events_view);
        int col = 2;

        recyclerView.setLayoutManager(new GridLayoutManager(this, col));
        eventsAdapter = new EventsAdapter(AdminEventsActivity.this,images);
        recyclerView.setAdapter(eventsAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
