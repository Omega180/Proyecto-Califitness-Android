package com.example.proyecto_android_clase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class lista_comidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_comidas)

        val lv_comidas = findViewById<ListView>(R.id.lv_comidas)

        //Adaptador de Arreglos

        val arrayAdapter: ArrayAdapter<*>

        val comidas = arrayOf("Pan con Queso y Jamon", "Pasta a la Bolognesa",
            "Hamburgesa de Pollo", "Huevos Revueltos", "Sopa de Mariscos")
        val comidasCalorias = arrayOf("300", "700", "400", "360", "900")
        arrayAdapter = ArrayAdapter(this, R.layout.list_item, comidas)
        lv_comidas.adapter = arrayAdapter
        lv_comidas.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@lista_comidas, "Seleccionaste ${comidas[position]}", Toast.LENGTH_SHORT).show()
            }

        }

    }
}