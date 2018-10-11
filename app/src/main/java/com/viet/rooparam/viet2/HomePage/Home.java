package com.viet.rooparam.viet2.HomePage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.viet.rooparam.viet2.Adapter.GridAdapter;
import com.viet.rooparam.viet2.Admin.AdminEventsActivity;
import com.viet.rooparam.viet2.Admin.AdminGallery;
import com.viet.rooparam.viet2.Admin.AdminProjectsActivity;
import com.viet.rooparam.viet2.Admin.Admin_News_Activity;
import com.viet.rooparam.viet2.Admin.ExaminationActivity;
import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.StudentDataModel;
import com.viet.rooparam.viet2.Time_Table.Time_Table;
import com.viet.rooparam.viet2.Utility.SessionManager;
import com.viet.rooparam.viet2.Viet.VyasLocationActivity;


public class Home extends Fragment {
    String branch_name, sem_name, roll_no;

    private OnFragmentInteractionListener mListener;

    int images[] = {R.drawable.ic_university, R.drawable.time_icon, R.drawable.news_icon, R.drawable.project_icon, R.drawable.events, R.drawable.result_icon, R.drawable.ic_gallery, R.drawable.location_icon};

    String grid_title[] = {"About Us", "Time Table", "News", "Projects", "Events", "Examination", "Gallery", "Locate Us"};

    GridView gridView;
    Viet_database database;
    SessionManager manager;
    StudentDataModel dataModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null);
        manager = new SessionManager(getActivity());
        database = new Viet_database(getActivity());
        roll_no = manager.getData().get(SessionManager.KEY_ROLL_NUMBER);
        gridView = (GridView) view.findViewById(R.id.home_gridview);
        dataModel = database.getStudent(roll_no);
        branch_name = dataModel.getBranch();
        sem_name = dataModel.getSemester();
        GridAdapter grid_Adapter = new GridAdapter(getActivity(), images, grid_title);

        gridView.setAdapter(grid_Adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent intent = new Intent(getActivity(), AboutUsActivity.class);
                    startActivity(intent);

                } else if (position == 1) {

                    Intent intent = new Intent(getActivity(), Time_Table.class);
                    intent.putExtra("branch", branch_name);
                    intent.putExtra("sem", sem_name);
                    startActivity(intent);

                } else if (position == 2) {

                    Intent intent = new Intent(getActivity(), Admin_News_Activity.class);
                    startActivity(intent);

                }  else if (position == 3) {
                    Intent intent = new Intent(getActivity(), AdminProjectsActivity.class);
                    startActivity(intent);

                } else if (position == 4) {
                    Intent intent = new Intent(getActivity(), AdminEventsActivity.class);
                    startActivity(intent);

                } else if (position == 5) {

                    Intent intent = new Intent(getActivity(), ExaminationActivity.class);
                    startActivity(intent);

                } else if (position == 6) {

                    Intent intent = new Intent(getActivity(), AdminGallery.class);
                    startActivity(intent);

                } else if (position == 7) {
                    Intent intent = new Intent(getActivity(), VyasLocationActivity.class);
                    startActivity(intent);
                }
            }


        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
