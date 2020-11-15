package com.example.tarea6deint.ui.dashboard;


import android.os.Handler;
import android.text.TextUtils;

public class DashBoardInteractorImpl {

    private DashBoardInteractor presenter;

    public DashBoardInteractorImpl(DashBoardInteractor presenter) {
        this.presenter = presenter;
    }


    public interface DashBoardInteractor {

        void onUserEmptyError(); //RN-U1 y Alternativa 1.1

        void onSuccess(); //Secuencia normal del caso de uso.
    }

    /**
     * Este método contiene la lógica empresarial del caso de uso UC1-Login
     * Se crea un hilo para simular el retardo de dos segundos y ver cómo en la
     * vista se visualiza una barra de progreso.
     *
     * @param user
     */
    public void validateCredentials(final String user) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //Reglas de negocio y  Alternativas del caso de uso UC1-Login
                //RN-U1 y Alternativa 1.1.: el usuario no puede ser nulo
                if (TextUtils.isEmpty(user)) {
                    presenter.onUserEmptyError();
                    return;
                }
                //Caso de éxito
                presenter.onSuccess();
            }
        }, 2000);
    }
}
