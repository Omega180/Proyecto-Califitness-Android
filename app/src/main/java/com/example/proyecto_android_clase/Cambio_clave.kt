package com.example.proyecto_android_clase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Cambio_clave : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambio_clave)
        val btn_cambio_ingresar = findViewById<Button>(R.id.btn_cambio_ingresar)
        btn_cambio_ingresar.setOnClickListener {
            val intent = Intent(this@Cambio_clave, pantalla_principal::class.java)
            startActivity(intent)
        }
    }
}