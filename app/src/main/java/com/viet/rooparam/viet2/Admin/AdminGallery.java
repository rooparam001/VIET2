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
import com.viet.rooparam.viet2.Adapter.GalleryAdapter;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Utility.SessionManager;

public class AdminGallery extends AppCompatActivity {

    int images[] = {R.drawable.galleryone, R.drawable.gallerytwo, R.drawable.gallerythree, R.drawable.galleryfour, R.drawable.galleryfive,
            R.drawable.gallerysix, R.drawable.galleryseven};

    GalleryAdapter galleryAdapter;

    TextView toolbar_gallery_title;

    Toolbar gallery_toolbar;

    SessionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_gallery);

        FloatingActionButton floating_button = (FloatingActionButton) findViewById(R.id.add_gallery_button);
        gallery_toolbar = findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(gallery_toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        toolbar_gallery_title = findViewById(R.id.toolbar_title);
        toolbar_gallery_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_gallery_title.setText("VIET Gallery");

        floating_button.setVisibility(View.GONE);

        manager = new SessionManager(AdminGallery.this);
        if (manager.getData().get(SessionManager.KEY_USERTYPE).equalsIgnoreCase("admin")) {
            floating_button.setVisibility(View.VISIBLE);
        } else {
            floating_button.setVisibility(View.GONE);
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery_view);
        int col = 1;

        recyclerView.setLayoutManager(new GridLayoutManager(this, col));
        galleryAdapter = new GalleryAdapter(AdminGallery.this,images);
        recyclerView.setAdapter(galleryAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
