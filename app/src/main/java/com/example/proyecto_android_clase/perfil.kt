package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val btn_guardar_perfil = findViewById<Button>(R.id.btn_guardar_perfil)
        btn_guardar_perfil.setOnClickListener {
            val intent = Intent(this@perfil, pantalla_principal::class.java)
            startActivity(intent)
        }
    }
}