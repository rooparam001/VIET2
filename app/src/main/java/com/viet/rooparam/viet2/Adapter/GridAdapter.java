package com.viet.rooparam.viet2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.viet.rooparam.viet2.R;

public class GridAdapter extends BaseAdapter {

    //Declaring variables used in this class
    Context context;
    int grid_Image[];
    String grid_name[];
    LayoutInflater inflater1;

    //Constructor Created
    public GridAdapter(Context applicationContext, int[] images, String[] grid_title) {
        this.context = applicationContext;
        this.grid_Image = images;
        this.grid_name = grid_title;
        inflater1 = LayoutInflater.from(applicationContext);
    }

    //getting name length
    @Override
    public int getCount() {
        return grid_name.length;
    }

    //getting name size
    @Override
    public Object getItem(int position) {
        return grid_name;
    }

    //getting name position
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //inflating Grid layout
    //setting name and image in layout
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater1.inflate(R.layout.home_grid_layout, null);

        ImageView grid_image = (ImageView) convertView.findViewById(R.id.grid_image);
        TextView grid_text = (TextView) convertView.findViewById(R.id.grid_text);

        grid_image.setImageResource(grid_Image[position]);
        grid_text.setText(grid_name[position]);

        return convertView;
    }
}
