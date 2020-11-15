package com.example.tarea6deint.ui.user;

import com.example.tarea6deint.ui.base.BaseView;

public interface LoginView extends BaseView {
    //Método que indica el usuario no puede ser nulo.
    void setUserEmptyError();

    //Método que indica que la contraseña no cumple el patrón indicado
    void setPasswordFormatError();

    //Método que indica la contraseña no puede ser nula
    void setPasswordEmptyError();
}
