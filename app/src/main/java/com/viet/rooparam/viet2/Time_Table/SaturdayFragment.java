package com.viet.rooparam.viet2.Time_Table;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.viet.rooparam.viet2.Adapter.Time_Table_Listview_Adapter;
import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Student.StudentDataModel;

import java.util.ArrayList;


public class SaturdayFragment extends Fragment {

    private OnFragmentInteractionListener mListener;


    ListView listView;
    View view;
    TextView text;

    Viet_database database;

    String branch_name, sem_name ,day_name ="Saturday";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            branch_name = getArguments().getString("branch");
            sem_name = getArguments().getString("sem");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<StudentDataModel> dataModels = new ArrayList<>();

        view = inflater.inflate(R.layout.fragment_saturday, null);
        listView = (ListView) view.findViewById(R.id.saturday_list_time_table);
        text = (TextView) view.findViewById(R.id.saturday_time_table_text);
        text.setVisibility(View.GONE);

        database = new Viet_database(getActivity());
        dataModels = database.getTimetable(day_name,branch_name,sem_name);

        Log.d("datamodel size", dataModels.size() + " ");

        Time_Table_Listview_Adapter adapter = new Time_Table_Listview_Adapter(getActivity(), dataModels);

        if (dataModels.size() <= 0) {
            text.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        } else {
            text.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            listView.setAdapter(adapter);
        }

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
