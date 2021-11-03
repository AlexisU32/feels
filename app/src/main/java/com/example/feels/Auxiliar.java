package com.example.feels;

import androidx.annotation.Nullable;

/**
 * @author Alexis Ruiz Uribe
 * @date 2/11/2021
 * @params
 * @resumen Clase para crear métodos que pueden ayudar para el tratamiento de textos y demas
 */
public class Auxiliar {

    /**
     * @author Alexis Ruiz Uribe
     * @date 2/11/2021
     * @params
     * @resumen Método para verificar si el texto ingresado es numérico
     */
    public boolean isNumeric(String text) {

        for (int i = 0; i < text.length() ; i++) {
            char caracter = text.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (!(valorASCII >= 48 && valorASCII <= 57)){
                return false;
            }
        }


        return true;
    }
}
