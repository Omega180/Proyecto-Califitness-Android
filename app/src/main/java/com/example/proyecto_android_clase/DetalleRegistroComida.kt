package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.proyecto_android_clase.roomDatabase.DBRoom
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

class DetalleRegistroComida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_registro_comida)
        //REFERENCIAS
        val extras = intent.extras
        val til_ingreso_comida = findViewById<TextInputLayout>(R.id.til_ingreso_comida)
        val til_ingreso_cal = findViewById<TextInputLayout>(R.id.til_ingreso_cal)
        val cb_comidas_fav = findViewById<CheckBox>(R.id.cb_comidas_fav)
        val btn_editar_comida = findViewById<Button>(R.id.btn_editar_comida)
        val btn_eliminar_comida = findViewById<Button>(R.id.btn_eliminar_comida)
        //INICIALIZAR DB
        val room = Room.databaseBuilder(this, DBRoom::class.java, "db-ciisa.db").allowMainThreadQueries().build()
        val user: String = intent.getStringExtra("user").toString()

        val idTipoComida: String = intent.getStringExtra("tipoComida").toString()
        val fechaNumero = extras?.getString("fecha_seleccionada")?:"No se selecciono una fecha"
        lifecycleScope.launch{
            var respComida = room.daoRegistroComida().obtenerComidaCreada(user,fechaNumero, idTipoComida)
            if(respComida.size>=1){
                for(element in respComida){
                    til_ingreso_comida.editText?.setText(element.nombre_comida.toString())
                    til_ingreso_cal.editText?.setText(element.cant_calorias.toString())
                    cb_comidas_fav.isChecked
                }
            }
        }

        btn_editar_comida.setOnClickListener {
            lifecycleScope.launch {
                var comida = til_ingreso_comida.editText?.text.toString()
                var calorias = til_ingreso_cal.editText?.text.toString()
                var comida_fav = cb_comidas_fav.isChecked
                val respComida = room.daoRegistroComida().actualizarRegistroComida(comida,calorias,comida_fav,user,fechaNumero,idTipoComida)
                println(respComida)
                val intent = Intent(this@DetalleRegistroComida,pantalla_principal::class.java)
                intent.putExtra("user", user)
                intent.putExtra("fecha", fechaNumero)
                startActivity(intent)

            }
        }

        btn_eliminar_comida.setOnClickListener {
            lifecycleScope.launch{
                val respComida = room.daoRegistroComida().borrarComida(user,fechaNumero,idTipoComida)
                println(respComida)
                val intent = Intent(this@DetalleRegistroComida,pantalla_principal::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
        }


    }
}