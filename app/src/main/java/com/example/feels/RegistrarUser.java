package com.example.feels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class RegistrarUser extends AppCompatActivity {

    Button volver_al_login;
    CheckBox terminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_user);
        volver_al_login = findViewById(R.id.btn_volver_registrar_user);
        terminos = findViewById(R.id.check_terminos_condiciones);

        /**
         * @author Alexis Ruiz Uribe
         * @date 26/10/2021
         * @params
         * @resumen Método para redireccionar al Login
         */
        volver_al_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });





    }
}