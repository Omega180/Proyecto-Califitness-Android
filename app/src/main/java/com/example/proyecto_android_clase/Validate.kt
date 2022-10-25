package com.example.proyecto_android_clase

import android.util.Patterns
import java.util.regex.Pattern

class Validate {

    // funcion para validar si el texto esta vacio

    fun validarCampoNulo(textValidate:String):Boolean {
        return textValidate.trim().equals("") || textValidate.trim().length==0
    }
    // funcion para validar si el texto esta vacio con expresiones regulares
    fun validateName(name:String):Boolean{
        val patron = Pattern.compile("^[a-zA-Z ]+\$")
        return patron.matcher(name).matches()
    }
    // funcion para validar si el correo es correcto atraves de RegEx

    fun validateFormCorreo(correo:String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    }

    //Funcion para validar si los campos son iguales
    fun validatePasswords(clave:String, claveRepetida:String):Boolean{
        return clave.trim().equals(claveRepetida)
    }
}