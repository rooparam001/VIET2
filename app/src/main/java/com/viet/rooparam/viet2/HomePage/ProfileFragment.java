package com.viet.rooparam.viet2.HomePage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.viet.rooparam.viet2.Database.Viet_database;
import com.viet.rooparam.viet2.R;
import com.viet.rooparam.viet2.Adapter.Spinner_Adapter;
import com.viet.rooparam.viet2.Student.StudentDataModel;

public class ProfileFragment extends Fragment {

    EditText name, father_name, roll, dob, gen, mail, mobile,branch_text,semester_text, adr,state_text, city, pin;

    Spinner semester, state;

    Button save;

    Viet_database database;

    StudentDataModel studentDataModel;

    String sem[] = {"1st Sem", "2nd Sem", "3rd Sem", "4th Sem", "5th Sem", "6th Sem", "7th Sem", "8th Sem"};
    String state_name[] = {"Andhra Pradesh ", "Arunachal Pradesh", "Bihar", "Uttar Pradesh", "Haryana", "Punjab", "Rajasthan", "West Bengal",
            "Jammu and Kashmir", "Himachal Pradesh", "Uttrakhand", "Gujrat", "Madhya Pradesh", "Jharkhand", "Chhattisgarh",
            "Odisha", "Telangana", "Maharashtra", "Goa", "Karnatka", "Tamil Nadu", "Kerala", "Sikkim", "Assam", "Meghalaya",
            "Nagaland", "Manipur", "Mizoram", "Tripura"};

    View view;

    String str1, str2, str3,roll_number;

    private OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            roll_number = getArguments().getString("roll");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_profile, null);

        name = (EditText) view.findViewById(R.id.student_name);
        father_name = (EditText) view.findViewById(R.id.father_name);
        roll = (EditText) view.findViewById(R.id.roll);
        dob = (EditText) view.findViewById(R.id.d_o_b);
        gen = (EditText) view.findViewById(R.id.gender);
        mail = (EditText) view.findViewById(R.id.email);
        mobile = (EditText) view.findViewById(R.id.phone);
        branch_text = (EditText) view.findViewById(R.id.branch_text);
        semester_text = (EditText) view.findViewById(R.id.semester_text);
        state_text = (EditText) view.findViewById(R.id.state_text);
        adr = (EditText) view.findViewById(R.id.address);
        city = (EditText) view.findViewById(R.id.city);
        pin = (EditText) view.findViewById(R.id.pincode);

        semester = (Spinner) view.findViewById(R.id.semester);
        state = (Spinner) view.findViewById(R.id.state);

        save = (Button) view.findViewById(R.id.save_btn);

        database = new Viet_database(getActivity());

        name.setEnabled(false);
        father_name.setEnabled(false);
        roll.setEnabled(false);
        dob.setEnabled(false);
        branch_text.setEnabled(false);
        semester_text.setEnabled(false);
        gen.setEnabled(false);
        mail.setEnabled(false);
        mobile.setEnabled(false);
        adr.setEnabled(false);
        state_text.setEnabled(false);
        city.setEnabled(false);
        pin.setEnabled(false);

        semester.setVisibility(View.GONE);
        state.setVisibility(View.GONE);

        Spinner_Adapter spinnerAdapter = new Spinner_Adapter(this.getActivity(), sem);

        semester.setAdapter(spinnerAdapter);

        Spinner_Adapter spinnerAdapter2 = new Spinner_Adapter(this.getActivity(), state_name);

        state.setAdapter(spinnerAdapter2);

        studentDataModel = database.getStudent(roll_number);

        name.setText(studentDataModel.student_name);
        roll.setText(studentDataModel.roll_number);
        mail.setText(studentDataModel.email);

        studentDataModel = database.getStudent(roll.getText().toString());
        father_name.setText(studentDataModel.father_name);
        dob.setText(studentDataModel.d_o_b);
        gen.setText(studentDataModel.gender);
        mobile.setText(studentDataModel.mobile_number);
        branch_text.setText(studentDataModel.branch);
        semester_text.setText(studentDataModel.semester);
        adr.setText(studentDataModel.address);
        state_text.setText(studentDataModel.state);
        city.setText(studentDataModel.city);
        pin.setText(studentDataModel.pin_code);

        FloatingActionButton btn = view.findViewById(R.id.floating_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                semester_text.setVisibility(View.GONE);
                state_text.setVisibility(View.GONE);

                mobile.setEnabled(true);

                semester.setVisibility(View.VISIBLE);
                state.setVisibility(View.VISIBLE);

                semester.setEnabled(true);
                adr.setEnabled(true);
                state.setEnabled(true);
                city.setEnabled(true);
                pin.setEnabled(true);

            }
        });

        semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str2 = sem[position];
                semester_text.setText(str2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str3 = state_name[position];
                state_text.setText(str3);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (father_name.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Please Enter Father Name.", Toast.LENGTH_SHORT).show();
                } else if (gen.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Please Enter Gender.", Toast.LENGTH_SHORT).show();
                } else if (mobile.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Please Enter Mobile.", Toast.LENGTH_SHORT).show();
                } else if (str2.equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Please Enter Semester.", Toast.LENGTH_SHORT).show();
                } else if (adr.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Please Enter Address.", Toast.LENGTH_SHORT).show();
                } else if (str3.equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Please Enter State.", Toast.LENGTH_SHORT).show();
                } else if (city.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Please Enter City.", Toast.LENGTH_SHORT).show();
                } else if (pin.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Please Enter PinCode.", Toast.LENGTH_SHORT).show();
                } else {

                    database.profileData(father_name.getText().toString(), roll_number, dob.getText().toString(), gen.getText().toString(),
                            mobile.getText().toString(), str1, str2, adr.getText().toString(), str3, city.getText().toString(),
                            pin.getText().toString());

                    father_name.setEnabled(false);
                    dob.setEnabled(false);

                    semester_text.setVisibility(View.VISIBLE);
                    state_text.setVisibility(View.VISIBLE);

                    semester_text.setEnabled(false);
                    mobile.setEnabled(false);
                    adr.setEnabled(false);
                    state_text.setEnabled(false);
                    city.setEnabled(false);
                    pin.setEnabled(false);

                    semester_text.setText(studentDataModel.semester);

                    semester.setVisibility(View.GONE);
                    state.setVisibility(View.GONE);

                    Toast.makeText(getActivity(), "Data Saved.", Toast.LENGTH_SHORT).show();

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
