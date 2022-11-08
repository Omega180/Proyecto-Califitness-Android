package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import com.google.android.material.textfield.TextInputLayout

class ingreso_comida_nuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_comida)

        val til_ingreso_comida = findViewById<TextInputLayout>(R.id.til_ingreso_comida)
        val til_ingreso_cal = findViewById<TextInputLayout>(R.id.til_ingreso_cal)
        val btn_ingreso = findViewById<Button>(R.id.btn_ingreso)
        val sp_comidas_fav = findViewById<Spinner>(R.id.sp_comidas_fav)


        //GENERACION SPINNER
        val arrayAdapterSpinner: ArrayAdapter<*>
        var comidas_fav = ArrayList<String>()
        comidas_fav.add("Pan con Queso y Jamon")
        comidas_fav.add("Pasta a la Bolognesa")
        comidas_fav.add("Hamburgesa de Pollo")
        comidas_fav.add("Huevos Revueltos")
        comidas_fav.add("Sopa de Mariscos")

        arrayAdapterSpinner = ArrayAdapter(this@ingreso_comida_nuevo, android.R.layout.simple_spinner_dropdown_item, comidas_fav)
        sp_comidas_fav.adapter = arrayAdapterSpinner

        //GENERACION LISTVIEW
        /*val arrayAdapterListView: ArrayAdapter<*>
        var comidas_fav_lv = ArrayList<String>()
        comidas_fav_lv.add("300")
        comidas_fav_lv.add("700")
        comidas_fav_lv.add("400")
        comidas_fav_lv.add("360")
        comidas_fav_lv.add("900")

        arrayAdapterListView = ArrayAdapter(this@ingreso_comida_nuevo, android.R.layout.simple_list_item_1, comidas_fav_lv)
        lv_comidas_fav.adapter = arrayAdapterListView*/

        btn_ingreso.setOnClickListener {
            if(validarIngreso()==0) {
                val intent = Intent(this@ingreso_comida_nuevo, pantalla_principal::class.java)
                startActivity(intent)
            } else {

            }

        }

    }

    fun validarIngreso():Int {
        var contIngresoComida:Int = 0
        var contIngresoCal:Int = 0
        var contFinal:Int = 0
        val til_ingreso_comida = findViewById<TextInputLayout>(R.id.til_ingreso_comida)
        val til_ingreso_cal = findViewById<TextInputLayout>(R.id.til_ingreso_cal)
        var ingreso_comida = til_ingreso_comida.editText?.text.toString()
        var ingreso_calorias = til_ingreso_cal.editText?.text.toString()

        val validarIngreso = Validate()
        if(validarIngreso.validarCampoNulo(ingreso_comida)) {
            til_ingreso_comida.error = "No puede dejar el campo vacio!"
            contIngresoComida++
        }
        else {
            til_ingreso_comida.error = ""
        }
        if(validarIngreso.validarCampoNulo(ingreso_calorias)) {
            til_ingreso_cal.error = "No puede dejar el campo vacio!"
            contIngresoCal++
        } else {
            til_ingreso_cal.error = ""
        }

        contFinal = contIngresoCal + contIngresoComida

        return contFinal
    }

}