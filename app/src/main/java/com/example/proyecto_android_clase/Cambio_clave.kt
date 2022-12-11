package com.example.proyecto_android_clase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class Cambio_clave : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambio_clave)
        val btn_cambio_ingresar = findViewById<Button>(R.id.btn_cambio_ingresar)
        btn_cambio_ingresar.setOnClickListener {
            if(validarContrasenaNueva()==0) {
                Toast.makeText(this@Cambio_clave, "Feature work in progress", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun validarContrasenaNueva():Int {
        var contador:Int = 0
        val til_cambio_clave = findViewById<TextInputLayout>(R.id.til_cambio_clave)
        val til_cambio_repetir = findViewById<TextInputLayout>(R.id.til_cambio_repetir)

        var clave = til_cambio_clave.editText?.text.toString()
        var repetir = til_cambio_repetir.editText?.text.toString()
        val validar = Validate()
        if(validar.validarCampoNulo(clave)) {
            til_cambio_clave.error = getString(R.string.error_campo_vacio)
            contador++
        } else {
            til_cambio_clave.error = ""
        }
        if(validar.validarCampoNulo(repetir)) {
            til_cambio_repetir.error = getString(R.string.error_campo_vacio)
            contador++
        } else {
            til_cambio_repetir.error = ""
        }
        if(contador == 0) {
            if(!validar.validatePasswords(clave, repetir)) {
                til_cambio_clave.error = getString(R.string.error_claves_coinciden)
                contador++
            } else {
                til_cambio_clave.error = ""
            }
        }
        return contador
    }
}