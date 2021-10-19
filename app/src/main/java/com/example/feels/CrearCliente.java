package com.example.feels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CrearCliente extends AppCompatActivity {

    /**
     * @author Alexis Ruiz Uribe
     * @date 10/10/2021
     * @params
     * @resumen Clase para la activity de Crear un Usuario Cliente
     */

    EditText user_cliente;
    TextView msg_cliente_user;
    Button siguiente_crear_cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cliente);

        user_cliente = findViewById(R.id.et_user_cliente_crearUser);
        msg_cliente_user = findViewById(R.id.tv_mensaje_de_user_encontrado);
        siguiente_crear_cliente = findViewById(R.id.btn_siguiente_cliente_crearUser);

        /**
         * @author Alexis Ruiz Uribe
         * @date 10/10/2021
         * @params
         * @resumen se bloquea el botón para que funcione solo cuando hayan datos en lo editext
         */
        siguiente_crear_cliente.setEnabled(false);
        siguiente_crear_cliente.setBackground(getResources().getDrawable(R.drawable.fondo_btn_ingresar_bloqueado));


        /**
         * @author Alexis Ruiz Uribe
         * @date 10/10/2021
         * @params
         * @resumen Con este método verificamos que cuando se escriba en los editex se desactive active el boton de siguiente
         */
        user_cliente.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Cada que detecte un ingreso de datos en el editext va a ejecutar el siguiente código
                if (!user_cliente.getText().toString().isEmpty()){
                    siguiente_crear_cliente.setEnabled(true);
                    siguiente_crear_cliente.setBackground(getResources().getDrawable(R.drawable.fondo_btn_ingresar));
                }else{
                    siguiente_crear_cliente.setEnabled(false);
                    siguiente_crear_cliente.setBackground(getResources().getDrawable(R.drawable.fondo_btn_ingresar_bloqueado));
                }

                msg_cliente_user.setText("");

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /**
         * @author Alexis Ruiz Uribe
         * @date 10/10/2021
         * @params
         * @resumen Con este método verificamos si el usuario está disponible o no, para luego seguir con el password
         */
        siguiente_crear_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!user_cliente.getText().toString().equals("Alexis")){
                    msg_cliente_user.setText("El usuario no está disponible");
                }
            }
        });




    }
}