package com.viet.rooparam.viet2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viet.rooparam.viet2.Admin.AdminProjectsActivity;
import com.viet.rooparam.viet2.R;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder>{

    //Declaring variables used in this class
    int[] title;
    int[] team;
    int[] date;
    Context context;
    LayoutInflater layoutInflater;

    //Constructor Created
    public ProjectsAdapter(AdminProjectsActivity adminProjectsActivity, int[] project_title, int[] project_team, int[] project_date) {

        this.context = adminProjectsActivity;
        this.title = project_title;
        this.team = project_team;
        this.date = project_date;
        layoutInflater = LayoutInflater.from(adminProjectsActivity);
    }

    //inflating Project layout
    @NonNull
    @Override
    public ProjectsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.projects_content_layout, null);
        return new ViewHolder(view);
    }

    //Setting text of project
    @Override
    public void onBindViewHolder(@NonNull ProjectsAdapter.ViewHolder holder, int position) {

        holder.project_name.setText(title[position]);
        holder.project_team.setText(team[position]);
        holder.project_date.setText(date[position]);

    }

    //getting text length
    @Override
    public int getItemCount() {
        return title.length;
    }

    //creating viewholder class for assigning the text
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView project_name = (TextView)itemView.findViewById(R.id.project_title);
        TextView project_team = (TextView)itemView.findViewById(R.id.team_name);
        TextView project_date = (TextView)itemView.findViewById(R.id.project_date);

        public ViewHolder(View view) {
            super(view);
        }


        @Override
        public void onClick(View view) {

        }
    }
}