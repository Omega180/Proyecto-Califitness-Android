package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btn_ingresar = findViewById<Button>(R.id.btn_registro_ingresar)

        btn_ingresar.setOnClickListener {
            val intent = Intent(this@Registro, pantalla_principal::class.java)
            startActivity(intent)
        }
    }
}