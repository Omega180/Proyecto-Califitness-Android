package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.room.Room
import com.example.proyecto_android_clase.roomDatabase.DBRoom

class crud_nuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)
        val room = Room.databaseBuilder(this, DBRoom::class.java, "db-ciisa.db")
            .allowMainThreadQueries()
            .build()
        val extras = intent.extras
        val tv_crud_fechaNumero = findViewById<TextView>(R.id.tv_crud_fechaNumero)
        val fechaNumero = extras?.getString("fecha_seleccionada")?:"No se selecciono una fecha"
        val img_btn_agregar_desayuno = findViewById<ImageButton>(R.id.img_btn_agregar_desayuno)
        val img_btn_agregar_almuerzo = findViewById<ImageButton>(R.id.img_btn_agregar_almuerzo)
        val img_btn_agregar_cena = findViewById<ImageButton>(R.id.img_btn_agregar_cena)
        val img_btn_agregar_extra = findViewById<ImageButton>(R.id.img_btn_agregar_extra)
        tv_crud_fechaNumero.text = fechaNumero
        img_btn_agregar_desayuno.setOnClickListener {
            val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
            intent.putExtra("tipoComida", "1")
            intent.putExtra("fecha", fechaNumero)
            startActivity(intent)
        }

        img_btn_agregar_almuerzo.setOnClickListener {
            val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
            intent.putExtra("tipoComida", "2")
            intent.putExtra("fecha", fechaNumero)
            startActivity(intent)

        }

        img_btn_agregar_cena.setOnClickListener {
            val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
            intent.putExtra("tipoComida", "3")
            intent.putExtra("fecha", fechaNumero)
            startActivity(intent)

        }

        img_btn_agregar_extra.setOnClickListener {
            val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
            intent.putExtra("tipoComida", "4")
            intent.putExtra("fecha", fechaNumero)
            startActivity(intent)
        }


    }
}