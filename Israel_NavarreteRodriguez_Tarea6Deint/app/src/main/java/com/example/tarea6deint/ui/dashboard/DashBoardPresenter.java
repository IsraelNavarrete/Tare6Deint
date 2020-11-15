package com.example.tarea6deint.ui.dashboard;

import com.example.tarea6deint.ui.login.LoginContract;
import com.example.tarea6deint.ui.login.LoginInteractorImpl;

public class DashBoardPresenter  implements DashBoardContract.Presenter, DashBoardInteractorImpl.DashBoardInteractor{

    private DashBoardContract.View view;
    private DashBoardInteractorImpl interactor;

    public DashBoardPresenter(DashBoardContract.View view) {
        this.view = view;
        this.interactor = new DashBoardInteractorImpl(this);
    }


    @Override
    public void validateCredentials(String UserName) {
        //1. Llamamos al método validateCredentials del Interactor.
        view.showProgress();

        //El interactor realiza las acciones oportunas con el usuario y el password - Validará el usuario
        interactor.validateCredentials(UserName);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }

    @Override
    public void onUserEmptyError() {
        view.hideProgress();
        view.setUserEmptyError();
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.onSuccess();
    }
}
