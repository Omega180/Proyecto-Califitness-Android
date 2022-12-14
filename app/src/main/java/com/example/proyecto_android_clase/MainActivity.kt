package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.proyecto_android_clase.roomDatabase.DBRoom
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val room = Room.databaseBuilder(this, DBRoom::class.java, "db-ciisa.db")
            // en caso de recibir error de migracion o version de base de datos
            // agregar aca .fallbackToDestructiveMigration(), correr la aplicacion para que se borre la base de datos
                //cerrar la app, borrar la linea de codigo, y volver a registrarse
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
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
            var user = til_main_correo.editText?.text.toString()
            var password = til_main_pass.editText?.text.toString()
            lifecycleScope.launch {
                if(validarCampos()==0) {
                    val response = room.daoUsuario().login(user, password)
                    if (response.size == 1) {
                        Toast.makeText(this@MainActivity, "Login Exitoso", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity, pantalla_principal::class.java)
                        intent.putExtra("user",user)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@MainActivity, "Login fallido, ingrese los datos correctos", Toast.LENGTH_SHORT).show()

                    }
                    var respuesta = room.daoUsuario().obtenerUsuarios()
                    for(elemento in respuesta) {
                        println(elemento.toString())
                    }

                } else {

                }
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