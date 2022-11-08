package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class explicacion_comida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicacion_comida)
        val extras = intent.extras
        val comidaNombre = extras?.getString("Selected_item_name")?:"no se selecciono una comida"
        val comidaCalorias = extras?.getString("Selected_item_calories")?:"no hay una cantidad de calorias"
        val tv_expli_comidaNombre = findViewById<TextView>(R.id.tv_expli_comidaNombre)
        val tv_expli_comidaCalorias = findViewById<TextView>(R.id.tv_expli_comidaCalorias)
        val btn_expli_regresar = findViewById<Button>(R.id.btn_expli_regresar)
        tv_expli_comidaNombre.text = comidaNombre
        tv_expli_comidaCalorias.text = comidaCalorias

        btn_expli_regresar.setOnClickListener {
            val intent = Intent(this@explicacion_comida, lista_comidas::class.java)
            startActivity(intent)
        }

    }
}