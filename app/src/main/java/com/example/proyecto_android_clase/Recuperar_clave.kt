package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Recuperar_clave : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_clave)

        val btn_recuperar_ingresar = findViewById<Button>(R.id.btn_recuperar_ingresar)

        btn_recuperar_ingresar.setOnClickListener {
            val intent = Intent(this@Recuperar_clave, Cambio_clave::class.java)
            startActivity(intent)
        }

    }
}