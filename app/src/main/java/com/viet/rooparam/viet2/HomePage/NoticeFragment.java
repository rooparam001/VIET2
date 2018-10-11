package com.viet.rooparam.viet2.HomePage;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.viet.rooparam.viet2.Adapter.NewsAdapter;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Utility.SessionManager;


public class NoticeFragment extends Fragment {

    int[] heading = {R.string.news_heading_1, R.string.news_heading_2, R.string.news_heading_3, R.string.news_heading_4, R.string.news_heading_5, R.string.news_heading_6,
            R.string.news_heading_7, R.string.news_heading_8, R.string.news_heading_9, R.string.news_heading_10};
    int[] date = {R.string.news_heading_date_1, R.string.news_heading_date_2, R.string.news_heading_date_3, R.string.news_heading_date_4, R.string.news_heading_date_5,
            R.string.news_heading_date_6, R.string.news_heading_date_7, R.string.news_heading_date_8, R.string.news_heading_date_9, R.string.news_heading_date_10};

    NewsAdapter newsAdapter;
    SessionManager manager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        FloatingActionButton floating_button = (FloatingActionButton) view.findViewById(R.id.add_notice_button);
        floating_button.setVisibility(View.GONE);

        manager = new SessionManager(getActivity());
        if (manager.getData().get(SessionManager.KEY_USERTYPE).equalsIgnoreCase("admin")) {
            floating_button.setVisibility(View.VISIBLE);
        } else {
            floating_button.setVisibility(View.GONE);
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.notice_view);
        int col = 1;

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), col));
        newsAdapter = new NewsAdapter(getActivity(), heading, date);
        recyclerView.setAdapter(newsAdapter);


        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
