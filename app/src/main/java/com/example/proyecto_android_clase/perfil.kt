package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val til_nombre_perfil = findViewById<TextInputLayout>(R.id.til_nombre_perfil)
        val til_correo_perfil = findViewById<TextInputLayout>(R.id.til_correo_perfil)
        val til_max_cal_perfil = findViewById<TextInputLayout>(R.id.til_max_cal_perfil)
        val btn_guardar_perfil = findViewById<Button>(R.id.btn_guardar_perfil)

        btn_guardar_perfil.setOnClickListener {
            if(validarPerfil()==0) {
                val intent = Intent(this@perfil, pantalla_principal::class.java)
                startActivity(intent)
            } else {

            }

        }

    }

    fun validarPerfil():Int {
        var contNombrePerfil:Int = 0
        var contCorreoPerfil:Int = 0
        var contMaxCalPerfil:Int = 0
        var contFinalPerfil:Int = 0
        val til_nombre_perfil = findViewById<TextInputLayout>(R.id.til_nombre_perfil)
        val til_correo_perfil = findViewById<TextInputLayout>(R.id.til_correo_perfil)
        val til_max_cal_perfil = findViewById<TextInputLayout>(R.id.til_max_cal_perfil)
        var nombre_perfil = til_nombre_perfil.editText?.text.toString()
        var correo_perfil = til_correo_perfil.editText?.text.toString()
        var max_cal_perfil = til_max_cal_perfil.editText?.text.toString()

        val validarPerfil = Validate()
        if(validarPerfil.validarCampoNulo(nombre_perfil)) {
            til_nombre_perfil.error = "No puede dejar el campo vacio!"
            contNombrePerfil++
        }
        if(validarPerfil.validarCampoNulo(correo_perfil)) {
            til_correo_perfil.error = "No puede dejar el campo vacio!"
            contCorreoPerfil++
        }
        if(validarPerfil.validarCampoNulo(max_cal_perfil)) {
            til_max_cal_perfil.error = "No puede dejar el campo vacio!"
            contMaxCalPerfil++
        }else {
            til_correo_perfil.error = ""
        }

        if(contCorreoPerfil == 0) {
            if(!validarPerfil.validateFormCorreo(correo_perfil)) {
                til_correo_perfil.error = "El Correo no posee el formato correcto"
                contCorreoPerfil++
            } else {
                til_correo_perfil.error = ""
            }
        }

        contFinalPerfil = contNombrePerfil + contCorreoPerfil + contMaxCalPerfil

        return contFinalPerfil
    }

}