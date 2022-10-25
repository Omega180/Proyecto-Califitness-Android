package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class Recuperar_clave : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_clave)
        val btn_recuperar_ingresar = findViewById<Button>(R.id.btn_recuperar_ingresar)

        btn_recuperar_ingresar.setOnClickListener {
            if(validarContrasena() == 0) {
                val intent = Intent(this@Recuperar_clave, Cambio_clave::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@Recuperar_clave, "Ingrese un correo valido", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun validarContrasena():Int {
        var contador:Int = 0
        val til_recuperar_correo = findViewById<TextInputLayout>(R.id.til_recuperar_correo)
        val correo = til_recuperar_correo.editText?.text.toString()
        val validar = Validate()
        if(validar.validarCampoNulo(correo)) {
            til_recuperar_correo.error = "el campo no puede estar vacio"
            contador++
        } else {
            til_recuperar_correo.error = ""
        }
        if(contador == 0) {
            if(!validar.validateFormCorreo(correo)) {
                til_recuperar_correo.error = "El correo no posee el formato correcto"
                contador++
            } else {
                til_recuperar_correo.error = ""
            }
         }
        return contador
    }
}