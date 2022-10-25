package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Val es igual a Const en js
        val til_main_correo = findViewById<TextInputLayout>(R.id.til_main_correo)
        val til_main_pass = findViewById<TextInputLayout>(R.id.til_main_pass)
        val btn_main_forgot = findViewById<Button>(R.id.btn_main_forgot)
        val btn_main_registrarse = findViewById<Button>(R.id.btn_main_registrarse)
        val btn_main_IS = findViewById<Button>(R.id.btn_main_IS)

        btn_main_registrarse.setOnClickListener {
            Toast.makeText(this@MainActivity,"Bienvenido al registro de usuario!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity,Registro::class.java)
            startActivity(intent)
        }

        btn_main_forgot.setOnClickListener {
            Toast.makeText(this@MainActivity, "Olvidaste tu contraseña?", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, Recuperar_clave::class.java)
            startActivity(intent)
        }
        btn_main_IS.setOnClickListener {
            if(validarCampos()==0) {
                val intent = Intent(this@MainActivity, pantalla_principal::class.java)
                startActivity(intent)
            } else {

            }

        }
    }
    fun validarCampos():Int {
        var contadorFinal:Int = 0
        var contadorUsuario:Int = 0
        var contadorClave:Int = 0
        val til_main_correo = findViewById<TextInputLayout>(R.id.til_main_correo)
        val til_main_pass = findViewById<TextInputLayout>(R.id.til_main_pass)
        var user = til_main_correo.editText?.text.toString()
        var password = til_main_pass.editText?.text.toString()

        val validar = Validate()
        if(validar.validarCampoNulo(user)) {
            til_main_correo.error = "No puede dejar el campo vacio!"
            contadorUsuario++
        }
        else {
            til_main_correo.error = ""
        }
        if(validar.validarCampoNulo(password)) {
            til_main_pass.error = "No puede dejar el campo vacio!"
            contadorClave++
        } else {
            til_main_pass.error = ""
        }
        if(contadorUsuario == 0) {
            if(!validar.validateFormCorreo(user)) {
                til_main_correo.error = "El Correo no posee el formato correcto"
                contadorUsuario++
            } else {
                til_main_correo.error = ""
            }
        }
        contadorFinal = contadorClave + contadorUsuario

        return contadorFinal
    }
}