package com.viet.rooparam.viet2.HomePage;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.viet.rooparam.viet2.R;

public class AboutUsActivity extends AppCompatActivity {

    TextView toolbar_titile;
    WebView webView_viet, webView_vision, webView_mission, webView_quality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        android.support.v7.widget.Toolbar about_us_toolbar = findViewById(R.id.viet_main_toolbar);
        setSupportActionBar(about_us_toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        toolbar_titile = (TextView) findViewById(R.id.toolbar_title);
        toolbar_titile.setText("About Us");
        webView_viet = (WebView) findViewById(R.id.about_viet_web_view);
        webView_vision = (WebView) findViewById(R.id.about_vision_web_view);
        webView_mission = (WebView) findViewById(R.id.about_MISSION_web_view);
        webView_quality = (WebView) findViewById(R.id.about_quality_web_view);
        webView_viet.loadUrl("file:///android_asset/about_viet.html");
        webView_mission.loadUrl("file:///android_asset/mission.html");
        webView_quality.loadUrl("file:///android_asset/quality.html");
        webView_vision.loadUrl("file:///android_asset/vision.html");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
