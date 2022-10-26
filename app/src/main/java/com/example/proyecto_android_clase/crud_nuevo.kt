package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class crud_nuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        val img_btn_agregar_desayuno = findViewById<ImageButton>(R.id.img_btn_agregar_desayuno)
        val img_btn_agregar_almuerzo = findViewById<ImageButton>(R.id.img_btn_agregar_almuerzo)
        val img_btn_agregar_cena = findViewById<ImageButton>(R.id.img_btn_agregar_cena)
        val img_btn_agregar_extra = findViewById<ImageButton>(R.id.img_btn_agregar_extra)

        img_btn_agregar_desayuno.setOnClickListener {
            val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
            startActivity(intent)
        }

        img_btn_agregar_almuerzo.setOnClickListener {
            val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
            startActivity(intent)
        }

        img_btn_agregar_cena.setOnClickListener {
            val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
            startActivity(intent)
        }

        img_btn_agregar_extra.setOnClickListener {
            val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
            startActivity(intent)
        }


    }
}