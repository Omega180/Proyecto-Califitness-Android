package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class configuracion_nuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        val btn_config_map = findViewById<Button>(R.id.btn_config_maps)
        val btn_guardar_conf = findViewById<Button>(R.id.btn_guardar_conf)
        btn_config_map.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }
        btn_guardar_conf.setOnClickListener {
            val intent = Intent(this@configuracion_nuevo, pantalla_principal::class.java)
            startActivity(intent)
        }
    }
}