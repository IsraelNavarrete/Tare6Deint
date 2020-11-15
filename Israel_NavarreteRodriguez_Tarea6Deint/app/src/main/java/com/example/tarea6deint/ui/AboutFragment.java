package com.example.tarea6deint.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.tarea6deint.R;

public class AboutFragment extends Fragment {

    Fragment fragmentAbout;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentAbout = new Fragment();

        Spinner spinner = (Spinner) view.findViewById(R.id.spLanguages);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.fragments, R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner.setAdapter(adapter);
        final NavController navController= Navigation.findNavController(view);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        break;
                    case 1:
                        navController.navigate(R.id.dashBoardFragment);
                        break;
                    case 2:
                        navController.navigate(R.id.aboutFragment);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}