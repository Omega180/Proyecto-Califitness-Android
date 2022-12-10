package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.proyecto_android_clase.roomDatabase.DBRoom
import kotlinx.coroutines.launch

class explicacion_comida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicacion_comida)
        val room = Room.databaseBuilder(this, DBRoom::class.java, "db-ciisa.db")
            .allowMainThreadQueries()
            .build()
        val extras = intent.extras
        val user: String = intent.getStringExtra("user").toString()
        val comidaNombre = extras?.getString("Selected_item_name")?:"no se selecciono una comida"
        val comidaCalorias = extras?.getString("Selected_item_calories")?:"no hay una cantidad de calorias"
        val tv_expli_comidaNombre = findViewById<TextView>(R.id.tv_expli_comidaNombre)
        val tv_expli_comidaCalorias = findViewById<TextView>(R.id.tv_expli_comidaCalorias)
        val btn_expli_regresar = findViewById<Button>(R.id.btn_expli_regresar)
        tv_expli_comidaNombre.text = comidaNombre
        tv_expli_comidaCalorias.text = comidaCalorias

        btn_expli_regresar.setOnClickListener {
            lifecycleScope.launch {
                var obtenerComidasNombre = room.daoRegistroComida().obtenerComidasFavoritasNombre(user, true)
                var obtenerComidasCalorias = room.daoRegistroComida().obtenerComidasFavoritasCalorias(user, true)
                intent.putExtra("user", user)
                intent.putExtra("comidasNombres", obtenerComidasNombre)
                intent.putExtra("comidasCalorias", obtenerComidasCalorias)
                val intent = Intent(this@explicacion_comida, lista_comidas::class.java)
                startActivity(intent)
            }

        }

    }
}