package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast

class pantalla_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        val btn_pantalla_profile = findViewById<Button>(R.id.btn_pantalla_profile)
        val btn_pantalla_settings = findViewById<Button>(R.id.btn_pantalla_settings)
        val btn_pantalla_home = findViewById<Button>(R.id.btn_pantalla_home)
        val btn_pantalla_listaComidas = findViewById<Button>(R.id.btn_pantalla_listaComidas)
        btn_pantalla_profile.setOnClickListener {
            val intent = Intent(this@pantalla_principal, perfil::class.java)
            startActivity(intent)
        }

        btn_pantalla_settings.setOnClickListener {
            val intent = Intent(this@pantalla_principal, configuracion_nuevo::class.java)
            startActivity(intent)
        }

        btn_pantalla_home.setOnClickListener {
            val intent = Intent(this@pantalla_principal, crud_nuevo::class.java)
            startActivity(intent)
        }

        btn_pantalla_listaComidas.setOnClickListener {
            val intent = Intent(this@pantalla_principal, lista_comidas::class.java)
            startActivity(intent)
        }

        val calendarioPrincipal = findViewById<View>(R.id.calendarioPrincipal) as CalendarView
        calendarioPrincipal.setOnDateChangeListener { view, year, month, dayOfMonth ->
            Toast.makeText(applicationContext, "${year}/${month}/${dayOfMonth}", Toast.LENGTH_LONG).show()
            val intent = Intent(this@pantalla_principal, crud_nuevo::class.java)
            intent.putExtra("fecha_seleccionada", "${year}, ${month}, ${dayOfMonth}")
            startActivity(intent)
        }
    }
}