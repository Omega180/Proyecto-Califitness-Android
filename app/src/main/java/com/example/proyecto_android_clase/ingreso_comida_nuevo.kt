package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.proyecto_android_clase.roomDatabase.DBRoom
import com.example.proyecto_android_clase.roomDatabase.entity.RegistroComida
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

class ingreso_comida_nuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_comida)
        val room = Room.databaseBuilder(this, DBRoom::class.java, "db-ciisa.db")
            .allowMainThreadQueries()
            .build()
        //val extras = intent.extras
        //val idTipoComida = extras?.getString("tipoComida", "0")
        val extras = intent.extras
        val user: String = intent.getStringExtra("user").toString()
        val idTipoComida: String = intent.getStringExtra("tipoComida").toString()
        //val fecha = extras?.getString("fecha", "No hay fecha")
        val fechaNumero = extras?.getString("fecha_seleccionada")?:"No se selecciono una fecha"
        val til_ingreso_comida = findViewById<TextInputLayout>(R.id.til_ingreso_comida)
        val til_ingreso_cal = findViewById<TextInputLayout>(R.id.til_ingreso_cal)
        val cb_comidas_fav = findViewById<CheckBox>(R.id.cb_comidas_fav)
        val btn_ingreso = findViewById<Button>(R.id.btn_editar_comida)
        val sp_comidas_fav = findViewById<Spinner>(R.id.sp_comidas_fav)
        //GENERACION SPINNER
        val arrayAdapterSpinner: ArrayAdapter<*>
        var comidas_fav = ArrayList<String>()
        comidas_fav.add("Pan con Queso y Jamon")
        comidas_fav.add("Pasta a la Bolognesa")
        comidas_fav.add("Hamburgesa de Pollo")
        comidas_fav.add("Huevos Revueltos")
        comidas_fav.add("Sopa de Mariscos")

        arrayAdapterSpinner = ArrayAdapter(
            this@ingreso_comida_nuevo,
            android.R.layout.simple_spinner_dropdown_item,
            comidas_fav
        )
        sp_comidas_fav.adapter = arrayAdapterSpinner


        btn_ingreso.setOnClickListener {

            var ingreso_comida = til_ingreso_comida.editText?.text.toString()
            var ingreso_calorias = til_ingreso_cal.editText?.text.toString()
            var comida_fav = cb_comidas_fav.isChecked
            var id:Long = 0
            var registroComida = RegistroComida(ingreso_comida, ingreso_calorias, fechaNumero, comida_fav, idTipoComida, user)

            lifecycleScope.launch {
                var respComida = room.daoRegistroComida().obtenerComidaCreada(user,fechaNumero, idTipoComida)
                if(respComida.size>=1){
                    Toast.makeText(this@ingreso_comida_nuevo, "Ya existe un registro, utilice boton editar", Toast.LENGTH_SHORT).show()
                }else{
                id = room.daoRegistroComida().agregarRegistroComida(registroComida)
                //OPCIONAL
                var respuesta = room.daoRegistroComida().obtenerRegistroComida()
                for(elemento in respuesta){
                    println(elemento.toString())

                }
                if (validarIngreso() == 0) {

                        if (id>0) {
                            Toast.makeText(this@ingreso_comida_nuevo,"Comida ingresada exitosamente",Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@ingreso_comida_nuevo, pantalla_principal::class.java)
                            intent.putExtra("user", user)
                            intent.putExtra("fecha", fechaNumero)
                            startActivity(intent)

                        }else {

                    }

                }


            }

            /**lifecycleScope.launch{
                val respuesta = room.daoRegistroComida().obtenerComidaporNombre(nombre_comida, FK_Usuario)
                if (respuesta.size == 1){
                    til_ingreso_comida.editText?.setText(elemento.nombre_comida)

                }
            }**/
        }
        }



    }
    fun validarIngreso(): Int {
        var contIngresoComida: Int = 0
        var contIngresoCal: Int = 0
        var contFinal: Int = 0
        val til_ingreso_comida = findViewById<TextInputLayout>(R.id.til_ingreso_comida)
        val til_ingreso_cal = findViewById<TextInputLayout>(R.id.til_ingreso_cal)
        var ingreso_comida = til_ingreso_comida.editText?.text.toString()
        var ingreso_calorias = til_ingreso_cal.editText?.text.toString()

        val validarIngreso = Validate()
        if (validarIngreso.validarCampoNulo(ingreso_comida)) {
            til_ingreso_comida.error = "No puede dejar el campo vacio!"
            contIngresoComida++
        } else {
            til_ingreso_comida.error = ""
        }
        if (validarIngreso.validarCampoNulo(ingreso_calorias)) {
            til_ingreso_cal.error = "No puede dejar el campo vacio!"
            contIngresoCal++
        } else {
            til_ingreso_cal.error = ""
        }

        contFinal = contIngresoCal + contIngresoComida

        return contFinal
    }
}