package com.example.tarea6deint.ui.signup;

public class SignUpPresenter implements SignUpContract.Presenter, SignUpInteractorImpl.SignUpInteractor{

    private SignUpContract.View view;
    private SignUpInteractorImpl interactor;
    public SignUpPresenter(SignUpContract.View view) {
        this.view=view;
        this.interactor = new SignUpInteractorImpl(this);
    }


    @Override
    public void validateCredentials(String userName, String password, String confirmPassword, String email) {
        //1. Llamamos al método validateCredentials del Interactor.
        view.showProgress();

        //El interactor realiza las acciones oportunas con el usuario y el password - Validará el usuario
        interactor.validateCredentials(userName, password,confirmPassword,email);
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
    public void onPasswordEmptyError() {
        view.hideProgress();
        view.setPasswordEmptyError();

    }

    @Override
    public void onPasswordFormatError() {
        view.hideProgress();
        view.setPasswordFormatError();

    }

    @Override
    public void onAuthenticationError() {
        view.hideProgress();
    }


    @Override
    public void onConfirmPasswordnotEqual() {
        view.hideProgress();
        view.setConfirmPasswordNotEqualError();

    }

    @Override
    public void onConfirmPasswordEmpty() {
        view.hideProgress();
        view.setConfirmPasswordEmptyError();

    }

    @Override
    public void onEmailEmpty() {
        view.hideProgress();
        view.setEmailEmptyError();

    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.onSuccess();

    }
}
