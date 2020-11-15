package com.example.tarea6deint.ui.signup;

import com.example.tarea6deint.ui.base.BasePresenter;
import com.example.tarea6deint.ui.user.LoginView;
import com.example.tarea6deint.ui.user.SignUpView;

public interface SignUpContract{
    interface View extends SignUpView {
        //Método que muestra una barra de progreso en la interfaz
        //mientras se realiza una acción en el interactor
        void showProgress();

        //Método que oculta la barra de progreso en la interfaz
        void  hideProgress();

    }

    interface Presenter extends BasePresenter{
        //Valida el usuario de la pantalla SignUp
        void validateCredentials(String userName, String password,String confirmPassword,String email);

    }
}
