package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class pantalla_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        val btn_pantalla_profile = findViewById<Button>(R.id.btn_pantalla_profile)
        val btn_pantalla_settings = findViewById<Button>(R.id.btn_pantalla_settings)
        btn_pantalla_profile.setOnClickListener {
            val intent = Intent(this@pantalla_principal, perfil::class.java)
            startActivity(intent)
        }

        btn_pantalla_settings.setOnClickListener {
            val intent = Intent(this@pantalla_principal, configuracion_nuevo::class.java)
            startActivity(intent)
        }
    }
}