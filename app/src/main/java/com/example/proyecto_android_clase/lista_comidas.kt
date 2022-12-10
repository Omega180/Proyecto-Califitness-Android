package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.room.Room
import com.example.proyecto_android_clase.roomDatabase.DBRoom

class lista_comidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_comidas)
        val room = Room.databaseBuilder(this, DBRoom::class.java, "db-ciisa.db")
            .allowMainThreadQueries()
            .build()
        val lv_comidas = findViewById<ListView>(R.id.lv_comidas)
        val user: String = intent.getStringExtra("user").toString()
        val arrayNombres: Array<String> = intent.getStringArrayExtra("comidasNombres") as Array<String>
        val arrayCalorias: Array<String> = intent.getStringArrayExtra("comidasCalorias") as Array<String>
        //Adaptador de Arreglos
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this, R.layout.list_item, arrayNombres)
        lv_comidas.adapter = arrayAdapter
        lv_comidas.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val intent = Intent(this@lista_comidas, explicacion_comida::class.java)
                intent.putExtra("user", user)
                intent.putExtra("Selected_item_name", arrayNombres[position])
                intent.putExtra("Selected_item_calories", arrayCalorias[position])
                startActivity(intent)
            }

        }

    }
}