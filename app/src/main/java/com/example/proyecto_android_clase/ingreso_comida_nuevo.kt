package com.example.proyecto_android_clase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class ingreso_comida_nuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_comida)

        val til_ingreso_comida = findViewById<TextInputLayout>(R.id.til_ingreso_comida)
        val til_ingreso_cal = findViewById<TextInputLayout>(R.id.til_ingreso_cal)
        val btn_ingreso = findViewById<Button>(R.id.btn_ingreso)

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