package com.example.tarea6deint.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarea6deint.ui.InventoryActivity;
import com.example.tarea6deint.ui.login.LoginActivity;
import com.example.tarea6deint.R;
import com.example.tarea6deint.ui.login.LoginContract;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View{
    private TextInputLayout tilUserName;
    private TextInputLayout tilPassword;
    private TextInputLayout tilEmail;
    private ProgressBar progressBar;
    private TextInputLayout tilConfirmPassword;
    private SignUpContract.Presenter presenter;

    private TextInputEditText tieUserName;
    private TextInputEditText tiePassword;
    private TextInputEditText tieEmail;
    private TextInputEditText tieConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Recogemos el nombre del usuario
        tieUserName = findViewById(R.id.tieUserName);

        //Recogemos la primera contraseña
        tiePassword= findViewById(R.id.tiePassword);
        //Recogemos la contraseña de confirmacion
         tieConfirmPassword= findViewById(R.id.tieConfirmPassword);

        //Recogemos email
         tieEmail= findViewById(R.id.tieEmail);

         progressBar = findViewById(R.id.progressBarSignUp);

        //Empieza los inputLayout

        //Recogemos el nombre del usuario
        tilUserName= findViewById(R.id.tilUserName);

        //Recogemos la primera contraseña
         tilPassword= findViewById(R.id.tilPassword);

        //Recogemos la contraseña de confirmacion
        tilConfirmPassword= findViewById(R.id.tilConfirmPassword);

        //Recogemos email
        tilEmail= findViewById(R.id.tilEmail);


        tieUserName.addTextChangedListener(new SignUpTextWatcher(tieUserName));
        tiePassword.addTextChangedListener(new SignUpTextWatcher(tiePassword));
        tieConfirmPassword.addTextChangedListener(new SignUpTextWatcher(tieConfirmPassword));
        tieEmail.addTextChangedListener(new SignUpTextWatcher(tieEmail));

        presenter = new SignUpPresenter( this);
    }

    /**
     * Metodo que comprueba si es valido el usuario, la contraseña y el email
     */
    public void validateUser(View view){
        presenter.validateCredentials(tieUserName.getText().toString(),tiePassword.getText().toString(),tieConfirmPassword.getText().toString(),tieEmail.getText().toString());
    }

    public void showLogin(View view){
        Intent intent = new Intent( SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }



    @Override
    public void setUserEmptyError() {
        tilUserName.setError(getResources().getString(R.string.err_user_empty));
    }

    @Override
    public void setPasswordFormatError() {
        tilPassword.setError(getResources().getString(R.string.err_password_format));
    }


    @Override
    public void setPasswordEmptyError() {
        tilPassword.setError(getResources().getString(R.string.err_password_empty));
    }

    @Override
    public void setEmailEmptyError() {
        tilEmail.setError(getResources().getString(R.string.err_email_empty));
    }

    @Override
    public void setConfirmPasswordNotEqualError() {
        tilConfirmPassword.setError(getResources().getString(R.string.err_confirmpassword_equal));
    }

    @Override
    public void setConfirmPasswordEmptyError() {
        tilConfirmPassword.setError(getResources().getString(R.string.err_confirmpassword_empty));
    }

    /**
     * Este metodo viene de la interfaz baseview
     */
    @Override
    public void onSuccess() {
        Intent intent = new Intent(SignUpActivity.this, InventoryActivity.class);
        startActivity(intent);
    }
    /**
     * Este metodo viene del contrato LoginContract.View
     */
    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    /**
     * Este metodo viene del contrato LoginContract.View
     */
    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    //region claseControlError
    class SignUpTextWatcher implements TextWatcher {

        private View view;

        SignUpTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.tieUserName:
                    validateUser(tieUserName.getText().toString());
                    break;
                case R.id.tiePassword:
                    validatePassword(tiePassword.getText().toString());
                    break;
                case R.id.tieConfirmPassword:
                    validateConfirmPassword(tieConfirmPassword.getText().toString());
                case R.id.tieEmail:
                    validateEmail(tieEmail.getText().toString());

            }
        }
    }

    private void validateUser(String userName) {
        if (tieUserName.getText().toString().trim().isEmpty()) {
            tilUserName.setError(getString(R.string.err_user_empty));
            tilUserName.requestFocus();
        }else {
            tilUserName.setErrorEnabled(false);
        }

    }

    private void validatePassword(String password) {
        if (tiePassword.getText().toString().trim().isEmpty()) {
            tilPassword.setError(getString(R.string.err_password_empty));
            tilPassword.requestFocus();

        }else if(tiePassword.getText().toString().length()<3) {
            tilPassword.setError(getString(R.string.err_password_format));
            tilPassword.requestFocus();
        }else {
            tilPassword.setErrorEnabled(false);
        }

    }

    private void validateConfirmPassword(String confirmPassword){
        if (tieConfirmPassword.getText().toString().trim().isEmpty()) {
            tilConfirmPassword.setError(getString(R.string.err_confirmpassword_empty));
            tilConfirmPassword.requestFocus();

        }else if(!tieConfirmPassword.getText().toString().equals(tiePassword.getText().toString())) {
            tilConfirmPassword.setError(getString(R.string.err_confirmpassword_equal));
            tilConfirmPassword.requestFocus();
        }else {
            tilConfirmPassword.setErrorEnabled(false);
        }
    }

    private void validateEmail(String email){
        if (tieEmail.getText().toString().trim().isEmpty()) {
            tilEmail.setError(getString(R.string.err_email_empty));
            tilEmail.requestFocus();

        }else {
            tilEmail.setErrorEnabled(false);
        }
    }
    //endregion
}
