package com.viet.rooparam.viet2.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.StudentDataModel;

import java.util.ArrayList;

public class Time_Table_Listview_Adapter extends BaseAdapter {

    //Declaring variables used in this class
    Context context;
    LayoutInflater inflater;
    ArrayList<StudentDataModel> dataModels = new ArrayList<StudentDataModel>();

    //Constructor Created
    public Time_Table_Listview_Adapter(Context context, ArrayList<StudentDataModel> studentDataModel) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.dataModels = studentDataModel;
    }

    //getting name length
    @Override
    public int getCount() {
        return dataModels.size();
    }

    //getting name size
    @Override
    public Object getItem(int position) {
        return dataModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //inflating list layout
    //setting name,roll and branch in list layout
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.time_table_layout,null);

        TextView time = (TextView) convertView.findViewById(R.id.edit_time);
        TextView subject = (TextView)convertView.findViewById(R.id.edit_subject);
        TextView teacher = (TextView)convertView.findViewById(R.id.edit_teacher);
        TextView room_no = (TextView)convertView.findViewById(R.id.edit_room_number);

        time.setText(dataModels.get(position).time);
        subject.setText(dataModels.get(position).subject);
        teacher.setText(dataModels.get(position).teacher_name);
        room_no.setText(dataModels.get(position).room_Number);

        return convertView;
    }
}
