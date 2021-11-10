package com.example.feels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrarUser extends AppCompatActivity {

    EditText name, lastname, email, cellphone, password1, password2;
    TextView llenarCampos;
    Button volver_al_login, registro;
    CheckBox terminos;

    // Instanciar objeto de la calse Auxiliar
    Auxiliar auxiliar = new Auxiliar();

    // Instanciar un objeto de la clase Handler
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_user);

        volver_al_login = findViewById(R.id.btn_volver_registrar_user);
        terminos = findViewById(R.id.check_terminos_condiciones);
        name = findViewById(R.id.et_name_registrar_user);
        lastname = findViewById(R.id.et_lastname_registrar_user);
        registro = findViewById(R.id.btn_registrarse_registrar_user);
        email = findViewById(R.id.et_email_registrar_user);
        cellphone = findViewById(R.id.et_cellphone_registrar_user);
        password1 = findViewById(R.id.et_password_1_registrar_user);
        password2 = findViewById(R.id.et_password_2_registrar_user);
        llenarCampos = findViewById(R.id.tv_llenar_campos);

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

        /**
         * @author Alexis Ruiz Uribe
         * @date 2/11/2021
         * @params
         * @resumen Método registrar el usuario
         */
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!terminos.isChecked()){
                    llenarCampos.setText("Debe haceptar los terminos y condiciones ");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            llenarCampos.setText("");
                        }
                    }, 2000);
                    return;
                }

                if (name.getText().toString().isEmpty()){
                    name.setBackground(getResources().getDrawable(R.drawable.fondo_btn_login_error));
                    llenarCampos.setText("Debe ingresar los campos en rojo");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            llenarCampos.setText("");
                        }
                    }, 2000);
                    name.requestFocus();
                    return;
                }else if(auxiliar.isNumeric(name.getText().toString())){
                    name.setBackground(getResources().getDrawable(R.drawable.fondo_btn_login));
                    llenarCampos.setText("El nombre no puede contener números");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            llenarCampos.setText("");
                        }
                    }, 2000);
                    name.requestFocus();
                    return;
                }else if(name.getText().toString().length() > 25){
                    name.setBackground(getResources().getDrawable(R.drawable.fondo_btn_login));
                    llenarCampos.setText("El nombre es demasiado largo");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            llenarCampos.setText("");
                        }
                    }, 2000);
                    name.requestFocus();
                    return;
                }


            }
        });

        /**
         * @author Alexis Ruiz Uribe
         * @date 2/11/2021
         * @params
         * @resumen Función para cerrar el teclado cunado se toca la pantalla fuera de los botones
         */
        View myView = findViewById(R.id.cons_my_view);
        myView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                closeTecladoMovil();
                return true;
            }
        });




    }

    /**
     * @author Alexis Ruiz Uribe
     * @date 2/11/2021
     * @params
     * @resumen Función para cerrar el teclado cunado se toca la pantalla fuera de los botones
     */
    private void closeTecladoMovil() {
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}