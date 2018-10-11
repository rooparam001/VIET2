package com.viet.rooparam.viet2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.StudentDataModel;

import java.util.ArrayList;

public class List_Adapter extends BaseAdapter {

    //Declaring variables used in this class
    Context context;
    ArrayList<StudentDataModel> studentDataModels = new ArrayList<>();
    LayoutInflater inflater;

    //Constructor Created
    public List_Adapter(Context applicationContext, ArrayList<StudentDataModel> studentDataModel) {
        this.context = applicationContext;
        this.studentDataModels = studentDataModel;
        inflater = LayoutInflater.from(applicationContext);
    }

    //getting name length
    @Override
    public int getCount() {
        return studentDataModels.size();
    }

    //getting name size
    @Override
    public Object getItem(int position) {
        return studentDataModels;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //inflating list layout
    //setting name,roll and branch in list layout
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.student_list_layout,null);

        TextView txt_name = (TextView)convertView.findViewById(R.id.txt_name);
        TextView txt_branch = (TextView)convertView.findViewById(R.id.txt_branch);
        TextView txt_roll = (TextView)convertView.findViewById(R.id.txt_roll);

        txt_name.setText(studentDataModels.get(position).student_name);
        txt_roll.setText(studentDataModels.get(position).roll_number);
        txt_branch.setText(studentDataModels.get(position).branch);

        return convertView;
    }
}
