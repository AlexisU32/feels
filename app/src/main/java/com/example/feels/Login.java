package com.example.feels;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    /**
     * @author Alexis Ruiz Uribe
     * @date 10/10/2021
     * @params
     * @resumen Clase para la activity del Login
     */

    // Referenciar los objetos del xml
    EditText user, password;
    TextView olvido_contraseña, registrarse;
    Button iniciar_sesion;

    // Instanciar un objeto de la clase Handler
    Handler handler = new Handler();

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Instanciar los objetos del xml
        user = findViewById(R.id.et_user_login);
        password = findViewById(R.id.et_password_login);
        olvido_contraseña = findViewById(R.id.tv_recuperar_password_login);
        registrarse = findViewById(R.id.tv_registrarse_login);
        iniciar_sesion = findViewById(R.id.btn_iniciar_sesion_login);

        /**
         * @author Alexis Ruiz Uribe
         * @date 10/10/2021
         * @params
         * @resumen se bloquea el botón para que funcione solo cuando hayan datos en lo editext
         */
        iniciar_sesion.setEnabled(false);
        iniciar_sesion.setBackground(getResources().getDrawable(R.drawable.fondo_btn_ingresar_bloqueado));

        /**
         * @author Alexis Ruiz Uribe
         * @date 10/10/2021
         * @params
         * @resumen Con este método verificamos que cuando se escriba en los editex se desactive active el boton de inicio de sessión
         */
        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if (!user.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                    iniciar_sesion.setEnabled(true);
                    iniciar_sesion.setBackground(getResources().getDrawable(R.drawable.fondo_btn_ingresar));
                }else{
                    iniciar_sesion.setEnabled(false);
                    iniciar_sesion.setBackground(getResources().getDrawable(R.drawable.fondo_btn_ingresar_bloqueado));
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        /**
         * @author Alexis Ruiz Uribe
         * @date 10/10/2021
         * @params
         * @resumen Con este método verificamos que cuando se escriba en los editex se desactive active el boton de inicio de sessión
         */
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if (!user.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                    iniciar_sesion.setEnabled(true);
                    iniciar_sesion.setBackground(getResources().getDrawable(R.drawable.fondo_btn_ingresar));
                }else{
                    iniciar_sesion.setEnabled(false);
                    iniciar_sesion.setBackground(getResources().getDrawable(R.drawable.fondo_btn_ingresar_bloqueado));
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        /**
         * @author Alexis Ruiz Uribe
         * @date 10/10/2021
         * @params
         * @resumen Función para validar el usuario y la contraseña para luego iniciar sesión
         */
        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Debe llenar este campo", Toast.LENGTH_SHORT).show();
                    user.requestFocus();
                    return;
                }

                if (password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Debe llenar este campo", Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                    return;
                }

                Toast.makeText(getApplicationContext(), "Ya ha iniciado sesión", Toast.LENGTH_SHORT).show();
                iniciar_sesion.setEnabled(false);
                iniciar_sesion.setBackground(getResources().getDrawable(R.drawable.fondo_btn_ingresar_bloqueado));
                user.setText("");
                password.setText("");
                user.requestFocus();
            }
        });

        /**
         * @author Alexis Ruiz Uribe
         * @date 10/10/2021
         * @params
         * @resumen Método para redireccionar al actyvity de recuperar la contraseña
         */
        olvido_contraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //startActivity(new Intent(getApplicationContext(), ));

            }
        });

        /**
         * @author Alexis Ruiz Uribe
         * @date 10/10/2021
         * @params
         * @resumen Método para redireccionar al actyvity de registrar al usuario
         */
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegistrarUser.class));
            }
        });



    }
}