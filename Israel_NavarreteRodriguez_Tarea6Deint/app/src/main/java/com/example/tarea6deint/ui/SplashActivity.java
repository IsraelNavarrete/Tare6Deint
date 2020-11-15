package com.example.tarea6deint.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.tarea6deint.ui.login.LoginActivity;
import com.example.tarea6deint.R;

public class SplashActivity extends AppCompatActivity {
    private static final long WAIT_TIME = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    /**
     * EN este método se debe ejecutar todas las operaciones de inicio de la aplicaión
     * como conectase a una base de datos, a un servidor... Simulamos el tiempo de espera
     * con un hilo que duerme 2 segundos y cuando despierta ejecuta el método initLogin
     */
    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initLogin();
            }
        }, WAIT_TIME);
    }

    private void initLogin() {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));

        //vamos a a llamar, de forma explicita, al método finish() que destruye la activity
        finish();
    }


}