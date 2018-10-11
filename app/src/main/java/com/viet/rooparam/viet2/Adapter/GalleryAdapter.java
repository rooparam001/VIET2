package com.viet.rooparam.viet2.Adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.viet.rooparam.viet2.Admin.AdminGallery;
import com.viet.rooparam.viet2.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    //Declaring variables used in this class
    int[] images_gallery;
    LayoutInflater layoutInflater;

    //Constructor Created
    public GalleryAdapter(AdminGallery adminGallery, int[] images) {
        this.images_gallery = images;

        layoutInflater = LayoutInflater.from(adminGallery);
    }

    //inflating Gallery layout
    @NonNull
    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.content_gallery_layout, null);
        return new GalleryAdapter.ViewHolder(view);
    }

    //Setting images of Gallery
    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.ViewHolder holder, int position) {
        holder.images_gallery.setImageResource(images_gallery[position]);
    }

    //getting number of images
    @Override
    public int getItemCount() {
        return images_gallery.length;
    }

    //creating viewholder class for assigning the images
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //crating variable for holding image
        ImageView images_gallery;

        //assigning xml id to variable
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images_gallery = (ImageView) itemView.findViewById(R.id.gallery_image);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
