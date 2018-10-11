package com.viet.rooparam.viet2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.viet.rooparam.viet2.Admin.AdminEventsActivity;
import com.viet.rooparam.viet2.R;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {


    //Declaring variables used in this class
    int[] images;
    LayoutInflater layoutInflater;

    //Constructor Created
    public EventsAdapter(Context context, int[] images) {

        this.images = images;
        layoutInflater = LayoutInflater.from(context);

    }

    //inflating Event layout
    @NonNull
    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.content_events_layout, null);
        return new ViewHolder(view);
    }

    //Setting images of events
    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.ViewHolder holder, int position) {
        holder.event_image.setImageResource(images[position]);
    }

    //getting images length
    @Override
    public int getItemCount() {
        return images.length;
    }

    //creating viewholder class for assigning the images
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //crating variable for holding image
        ImageView event_image;

        //assigning xml id to variable
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            event_image = (ImageView) itemView.findViewById(R.id.event_image);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
