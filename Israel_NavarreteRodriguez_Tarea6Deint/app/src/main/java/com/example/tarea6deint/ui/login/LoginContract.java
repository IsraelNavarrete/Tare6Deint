package com.example.tarea6deint.ui.login;

import com.example.tarea6deint.ui.base.BasePresenter;
import com.example.tarea6deint.ui.user.LoginView;

public interface LoginContract {

    interface View extends LoginView {
        //Método que muestra una barra de progreso en la interfaz
        //mientras se realiza una acción en el interactor
        void showProgress();

        //Método que oculta la barra de progreso en la interfaz
        void  hideProgress();

    }

    interface Presenter extends BasePresenter {
        //Valida el usuario de la pantalla Login
        void validateCredentials(String email, String password);

    }

}
