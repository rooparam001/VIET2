package com.viet.rooparam.viet2.Admin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.viet.rooparam.viet2.Adapter.GridAdapter;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.Student_List;
import com.viet.rooparam.viet2.Viet.VyasLocationActivity;

public class AdminPanel extends Fragment {
    private OnFragmentInteractionListener mListener;

    int images[] = {R.drawable.ic_student_1, R.drawable.time_icon, R.drawable.news_icon, R.drawable.project_icon, R.drawable.events, R.drawable.result_icon, R.drawable.ic_gallery, R.drawable.location_icon};

    String grid_title[] = {"Student Info", "Time Table", "News", "Projects", "Events", "Examination", "Gallery", "Locate Us"};

    GridView admin_gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_panel, null);

        admin_gridView = (GridView) view.findViewById(R.id.admin_home_gridview);

        GridAdapter gridAdapter = new GridAdapter(getActivity(), images, grid_title);

        admin_gridView.setAdapter(gridAdapter);

        admin_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent intent =  new Intent(getActivity(), Student_List.class);
                    startActivity(intent);

                } else if (position == 1) {

                    Intent intent = new Intent(getActivity(), Admin_Create_Time_Table.class);
                    startActivity(intent);

                } else if (position == 2) {

                    Intent intent = new Intent(getActivity(), Admin_News_Activity.class);
                    startActivity(intent);

                } else if (position == 3) {

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
