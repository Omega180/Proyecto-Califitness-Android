package com.example.proyecto_android_clase

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val til_registro_name = findViewById<TextInputLayout>(R.id.til_registro_name)
        val til_registro_email = findViewById<TextInputLayout>(R.id.til_registro_email)
        val til_registro_fecha_nac = findViewById<TextInputLayout>(R.id.til_registro_fecha_nac)
        val til_registro_pass = findViewById<TextInputLayout>(R.id.til_registro_pass)
        val btn_ingresar = findViewById<Button>(R.id.btn_registro_ingresar)

        val cal = Calendar.getInstance()

        //DATEPICKER
        val listenerFecha = DatePickerDialog.OnDateSetListener { datePicker, anyo, mes, dia ->
            til_registro_fecha_nac.editText?.setText("$dia/$mes/$anyo")
        }
        til_registro_fecha_nac.editText?.setOnClickListener {
            DatePickerDialog(this,listenerFecha,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        btn_ingresar.setOnClickListener {
            if(validarCampos()==0) {
                val intent = Intent(this@Registro, pantalla_principal::class.java)
                startActivity(intent)
            } else {

            }

        }
    }

    fun validarCampos():Int {
        var contadorFinal:Int = 0
        var contadorUsuario:Int = 0
        var contadorClave:Int = 0
        var contadorCorreo:Int = 0
        val til_registro_name = findViewById<TextInputLayout>(R.id.til_registro_name)
        val til_registro_email = findViewById<TextInputLayout>(R.id.til_registro_email)
        val til_registro_pass = findViewById<TextInputLayout>(R.id.til_registro_pass)
        var user = til_registro_name.editText?.text.toString()
        var password = til_registro_pass.editText?.text.toString()
        var email = til_registro_email.editText?.text.toString()

        val validar = Validate()
        if(validar.validarCampoNulo(user)) {
            til_registro_name.error = "No puede dejar el campo vacio!"
            contadorUsuario++
        }
        else {
            til_registro_name.error = ""
            contadorUsuario = 0
        }
        if(validar.validarCampoNulo(password)) {
            til_registro_pass.error = "No puede dejar el campo vacio!"
            contadorClave++
        } else {
            til_registro_pass.error = ""
            contadorClave = 0
        }
        if(validar.validarCampoNulo(email)) {
            til_registro_email.error = "No puede dejar el campo vacio!"
            contadorCorreo++
        } else {
            til_registro_email.error = ""
            contadorCorreo = 0
        }
        if(contadorCorreo == 0) {
            if(!validar.validateFormCorreo(email)) {
                til_registro_email.error = "El Correo no posee el formato correcto"
                contadorCorreo++
            } else {
                til_registro_email.error = ""
            }
        }
        contadorFinal = contadorClave + contadorUsuario + contadorCorreo

        return contadorFinal
    }
}