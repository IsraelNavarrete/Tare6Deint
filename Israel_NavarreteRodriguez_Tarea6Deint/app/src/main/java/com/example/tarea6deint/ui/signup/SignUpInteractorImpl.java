package com.example.tarea6deint.ui.signup;

import android.os.Handler;
import android.text.TextUtils;


public class SignUpInteractorImpl {

    private SignUpInteractor presenter;

    /*
     * Definición de las interfaces que debe implementar cualquier presentador
     * que haga uso del Interactor.
     */
    public interface SignUpInteractor {

        void onUserEmptyError(); //RN-U1 y Alternativa 1.1

        void onPasswordEmptyError(); //RN-U1 y Alternativa 1.1

        void onPasswordFormatError(); //RN-U2 y Alternativa 1.2

        void onAuthenticationError(); //Alternativa 1.3

        void onConfirmPasswordnotEqual();

        void onConfirmPasswordEmpty();

        void onEmailEmpty();

        void onSuccess(); //Secuencia normal del caso de uso.
    }

    public SignUpInteractorImpl(SignUpInteractor presenter) {
        this.presenter = presenter;
    }

    /**
     * Este método contiene la lógica empresarial del caso de uso UC1-Login
     * Se crea un hilo para simular el retardo de dos segundos y ver cómo en la
     * vista se visualiza una barra de progreso.
     *
     * @param user
     * @param password
     */
    public void validateCredentials(final String user, final String password,final String confirmPassword, final String email) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //Reglas de negocio y  Alternativas del caso de uso UC1-Login
                //RN-U1 y Alternativa 1.1.: el usuario no puede ser nulo
                if (TextUtils.isEmpty(user)) {
                    presenter.onUserEmptyError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    presenter.onPasswordEmptyError();
                    return;
                }

                if (TextUtils.getTrimmedLength(password)<3)
                {
                    presenter.onPasswordFormatError();
                    return;
                }

                if (!confirmPassword.trim().equals(password.trim()))
                {
                    presenter.onConfirmPasswordnotEqual();
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword))
                {
                    presenter.onConfirmPasswordEmpty();
                    return;
                }
                if (TextUtils.isEmpty(email))
                {
                    presenter.onEmailEmpty();
                    return;
                }
                //Caso de éxito
                presenter.onSuccess();
            }
        }, 2000);
    }
}
