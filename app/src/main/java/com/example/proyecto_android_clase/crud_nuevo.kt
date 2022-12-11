package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.proyecto_android_clase.roomDatabase.DBRoom
import kotlinx.coroutines.launch

class crud_nuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)
        val room = Room.databaseBuilder(this, DBRoom::class.java, "db-ciisa.db")
            .allowMainThreadQueries()
            .build()
        val tv_crud_fechaNumero = findViewById<TextView>(R.id.tv_crud_fechaNumero)
        val extras = intent.extras
        val FK_Usuario:String = intent.getStringExtra("FK_Usuario").toString()
        val nombre_comida:String = intent.getStringExtra("nombre_comida").toString()

        val fechaNumero: String = intent.getStringExtra("fecha_seleccionada").toString()
        val btn_agregar_desayuno = findViewById<Button>(R.id.btn_agregar_desayuno)
        val btn_agregar_almuerzo = findViewById<Button>(R.id.btn_agregar_almuerzo)
        val btn_agregar_cena = findViewById<Button>(R.id.btn_agregar_cena)
        val btn_agregar_extra = findViewById<Button>(R.id.btn_agregar_extra)
        val btn_editar_desayuno = findViewById<Button>(R.id.btn_editar_desayuno)
        val btn_editar_almuerzo = findViewById<Button>(R.id.btn_editar_almuerzo)
        val btn_editar_cena = findViewById<Button>(R.id.btn_editar_cena)
        val btn_editar_extra = findViewById<Button>(R.id.btn_editar_extra)
        val user: String = intent.getStringExtra("user").toString()
        tv_crud_fechaNumero.text = fechaNumero

        btn_agregar_desayuno.setOnClickListener {
            lifecycleScope.launch {
                val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
                var obtenerComidasNombre = room.daoRegistroComida().obtenerComidasFavoritasNombre(user, true)
                var obtenerComidasCalorias = room.daoRegistroComida().obtenerComidasFavoritasCalorias(user, true)
                intent.putExtra("comidasNombres", obtenerComidasNombre)
                intent.putExtra("comidasCalorias", obtenerComidasCalorias)
                intent.putExtra("user", user)
                intent.putExtra("tipoComida", "1")
                intent.putExtra("fecha", fechaNumero)

                startActivity(intent)
            }

        }

        btn_agregar_almuerzo.setOnClickListener {
            lifecycleScope.launch {
                val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
                var obtenerComidasNombre = room.daoRegistroComida().obtenerComidasFavoritasNombre(user, true)
                var obtenerComidasCalorias = room.daoRegistroComida().obtenerComidasFavoritasCalorias(user, true)
                intent.putExtra("comidasNombres", obtenerComidasNombre)
                intent.putExtra("comidasCalorias", obtenerComidasCalorias)
                intent.putExtra("user", user)
                intent.putExtra("tipoComida", "2")
                intent.putExtra("fecha", fechaNumero)
                startActivity(intent)
            }


        }

        btn_agregar_cena.setOnClickListener {
            lifecycleScope.launch {
                val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
                var obtenerComidasNombre = room.daoRegistroComida().obtenerComidasFavoritasNombre(user, true)
                var obtenerComidasCalorias = room.daoRegistroComida().obtenerComidasFavoritasCalorias(user, true)
                intent.putExtra("comidasNombres", obtenerComidasNombre)
                intent.putExtra("comidasCalorias", obtenerComidasCalorias)
                intent.putExtra("user", user)
                intent.putExtra("tipoComida", "3")
                intent.putExtra("fecha", fechaNumero)
                startActivity(intent)
            }


        }

        btn_agregar_extra.setOnClickListener {
            lifecycleScope.launch {
                val intent = Intent(this@crud_nuevo, ingreso_comida_nuevo::class.java)
                var obtenerComidasNombre = room.daoRegistroComida().obtenerComidasFavoritasNombre(user, true)
                var obtenerComidasCalorias = room.daoRegistroComida().obtenerComidasFavoritasCalorias(user, true)
                intent.putExtra("comidasNombres", obtenerComidasNombre)
                intent.putExtra("comidasCalorias", obtenerComidasCalorias)
                intent.putExtra("user", user)
                intent.putExtra("tipoComida", "4")
                intent.putExtra("fecha", fechaNumero)
                startActivity(intent)
            }

        }

        btn_editar_desayuno.setOnClickListener {
            lifecycleScope.launch {
                val intent = Intent(this@crud_nuevo, DetalleRegistroComida::class.java)
                intent.putExtra("user", user)
                intent.putExtra("tipoComida", "1")
                intent.putExtra("fecha", fechaNumero)
                startActivity(intent)
            }
        }

        btn_editar_almuerzo.setOnClickListener {
            lifecycleScope.launch {
                val intent = Intent(this@crud_nuevo, DetalleRegistroComida::class.java)
                intent.putExtra("user", user)
                intent.putExtra("tipoComida", "2")
                intent.putExtra("fecha", fechaNumero)
                startActivity(intent)
            }
        }

        btn_editar_cena.setOnClickListener {
            lifecycleScope.launch {
                val intent = Intent(this@crud_nuevo, DetalleRegistroComida::class.java)
                intent.putExtra("user", user)
                intent.putExtra("tipoComida", "3")
                intent.putExtra("fecha", fechaNumero)
                startActivity(intent)
            }
        }

        btn_editar_extra.setOnClickListener {
            lifecycleScope.launch {
                val intent = Intent(this@crud_nuevo, DetalleRegistroComida::class.java)
                intent.putExtra("user", user)
                intent.putExtra("tipoComida", "4")
                intent.putExtra("fecha", fechaNumero)
                startActivity(intent)
            }
        }


    }
}