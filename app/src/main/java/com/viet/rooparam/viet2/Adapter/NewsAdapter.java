package com.viet.rooparam.viet2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.viet.rooparam.viet2.Admin.Admin_News_Activity;
import com.viet.rooparam.viet2.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    //Declaring variables used in this class
    int[] heading;
    int[] date;
    private LayoutInflater inflater;

    //Constructor Created
    public NewsAdapter(Context context, int[] heading, int[] date) {
        this.heading = heading;
        this.date = date;
        inflater = LayoutInflater.from(context);
    }

    //inflating News layout
    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.news_content_view,null);
        return new ViewHolder(view);
    }

    //Setting Text of News layout
    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, int i) {

        viewHolder.news_heading.setText(heading[i]);
        viewHolder.news_date.setText(date[i]);

    }

    //getting text length
    @Override
    public int getItemCount() {
        return heading.length;
    }

    //creating viewholder class for assigning the text
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //crating variable for holding text
        TextView news_heading,news_date;

        //assigning xml id to variable
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            news_heading = (TextView)itemView.findViewById(R.id.news_heading);
            news_date = (TextView)itemView.findViewById(R.id.news_date);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
