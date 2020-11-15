package com.example.tarea6deint.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarea6deint.R;
import com.example.tarea6deint.ui.InventoryActivity;
import com.example.tarea6deint.ui.signup.SignUpActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter presenter;
    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private ProgressBar progressBar;
    private TextInputEditText tieEmail;
    private TextInputEditText tiePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBar);
        tilEmail = findViewById(R.id.tilEmail);
        tilPassword = findViewById(R.id.tilPassword);
        tieEmail = findViewById(R.id.tieEmail);
        tieEmail.addTextChangedListener(new LoginTextWatcher(tieEmail));
        tiePassword = findViewById(R.id.tiePassword);
        tiePassword.addTextChangedListener(new LoginTextWatcher(tiePassword));
        presenter = new LoginPresenter(this);
    }

    public void showSignUp(View view){
        Intent intent = new Intent( LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }




    /**
     * Metodo que valida si el inicio de sesion es correcto
     * @param view
     */
    public void validateUser(View view)
    {
        presenter.validateCredentials(tieEmail.getText().toString(),tiePassword.getText().toString());
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



    /**
     * Este metodo viene de la interfaz baseview
     */
    @Override
    public void onSuccess() {
        Intent intent = new Intent(LoginActivity.this, InventoryActivity.class);
        startActivity(intent);

    }

    /**
     * Este metodo viene de la interfaz UserView
     */
    @Override
    public void setUserEmptyError() {
        tilEmail.setError(getResources().getString(R.string.err_user_empty));
    }

    /**
     * Este metodo viene de la interfaz UserView
     */
    @Override
    public void setPasswordFormatError() {
        tilPassword.setError(getResources().getString(R.string.err_password_format));
    }
    /**
     * Este metodo viene de la interfaz UserView
     */
    @Override
    public void setPasswordEmptyError() {
        tilPassword.setError(getResources().getString(R.string.err_password_empty));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    //region claseControlError
    class LoginTextWatcher implements TextWatcher {

        private View view;

        LoginTextWatcher(View view) {
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
                case R.id.tieEmail:
                    validateUser(tieEmail.getText().toString());
                    break;
                case R.id.tiePassword:
                    validatePassword(tiePassword.getText().toString());
                    break;

            }
        }
    }

    private void validateUser(String password) {
        if (tieEmail.getText().toString().trim().isEmpty()) {
            tilEmail.setError(getString(R.string.err_user_empty));
            tilEmail.requestFocus();
        }else {
            tilEmail.setErrorEnabled(false);
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
    //endregion
}