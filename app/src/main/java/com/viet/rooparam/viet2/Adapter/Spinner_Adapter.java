package com.viet.rooparam.viet2.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.viet.rooparam.viet2.R;

public class Spinner_Adapter extends BaseAdapter {

    //Declaring variables used in this class
    Context context;
    String name[];
    LayoutInflater inflater;

    //Constructor Created
    public Spinner_Adapter(Context activity, String[] sem) {
        this.context = activity;
        this.name = sem;
        inflater = LayoutInflater.from(activity);
    }

    //getting name length
    @Override
    public int getCount() {
        return name.length;
    }

    //getting name size
    @Override
    public Object getItem(int position) {
        return name;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //inflating list layout
    //setting name,roll and branch in list layout
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.spinner_layout,null);

        TextView text = (TextView)convertView.findViewById(R.id.et_text);

        text.setText(name[position]);

        return convertView;
    }
}
