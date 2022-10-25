package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class configuracion_nuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        val btn_guardar_conf = findViewById<Button>(R.id.btn_guardar_conf)
        btn_guardar_conf.setOnClickListener {
            val intent = Intent(this@configuracion_nuevo, pantalla_principal::class.java)
            startActivity(intent)
        }
    }
}