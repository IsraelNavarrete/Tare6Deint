package com.example.tarea6deint.ui.dashboard;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tarea6deint.R;
import com.example.tarea6deint.ui.login.LoginActivity;
import com.example.tarea6deint.ui.login.LoginContract;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DashBoardFragment extends Fragment implements DashBoardContract.View {
    private DashBoardContract.Presenter presenter;
    Fragment fragmentDashboard;
    TextView tvUserName;
    TextView tvEmail;
    Button btChangeUserName;
    TextInputLayout tilUserNameProfile;
    ProgressBar progressBarDashBoard;
    TextInputEditText tieUserNameProfile;
    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        tilUserNameProfile = view.findViewById(R.id.tilUsernameProfile);
        progressBarDashBoard = view.findViewById(R.id.progressBarDashBoard);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvUserName = view.findViewById(R.id.tvUserName);
        tieUserNameProfile = view.findViewById(R.id.tieUserNameProfile);
        btChangeUserName = view.findViewById(R.id.btChangeUserName);
        presenter = new DashBoardPresenter(this);
        btChangeUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateUser();
            }
        });
        return view;
    }


    public void ValidateUser(){
        presenter.validateCredentials(tieUserNameProfile.getText().toString());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentDashboard = new Fragment();

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



    /**
     * Este metodo viene del contrato LoginContract.View
     */
    @Override
    public void showProgress() {
        progressBarDashBoard.setVisibility(View.VISIBLE);
    }

    /**
     * Este metodo viene del contrato LoginContract.View
     */
    @Override
    public void hideProgress() {
        progressBarDashBoard.setVisibility(View.GONE);
    }



    /**
     * Este metodo viene de la interfaz baseview
     */
    @Override
    public void onSuccess() {
        tvUserName.setText(tieUserNameProfile.getText().toString());
    }

    /**
     * Este metodo viene de la interfaz UserView
     */
    @Override
    public void setUserEmptyError() {
        tilUserNameProfile.setError(getResources().getString(R.string.err_user_empty));
    }



}
