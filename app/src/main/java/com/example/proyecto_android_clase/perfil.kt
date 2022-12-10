package com.example.proyecto_android_clase

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.textfield.TextInputLayout

class perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val til_nombre_perfil = findViewById<TextInputLayout>(R.id.til_nombre_perfil)
        val til_correo_perfil = findViewById<TextInputLayout>(R.id.til_correo_perfil)
        val til_max_cal_perfil = findViewById<TextInputLayout>(R.id.til_max_cal_perfil)
        val btn_guardar_perfil = findViewById<Button>(R.id.btn_guardar_perfil)
        val btn_perfil_photo = findViewById<Button>(R.id.btn_perfil_photo)
        btn_perfil_photo.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            asignarFoto.launch(intent)
        }

        btn_guardar_perfil.setOnClickListener {
            if(validarPerfil()==0) {
                val intent = Intent(this@perfil, pantalla_principal::class.java)
                startActivity(intent)
            } else {

            }

        }

    }
    private val asignarFoto = registerForActivityResult(

        ActivityResultContracts.StartActivityForResult()
    ) {
        result : ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val imageBitmap = intent?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.imv_perfil)
            imageView.setImageBitmap(imageBitmap)
        }
    }
    fun validarPerfil():Int {
        var contNombrePerfil:Int = 0
        var contCorreoPerfil:Int = 0
        var contMaxCalPerfil:Int = 0
        var contFinalPerfil:Int = 0
        val til_nombre_perfil = findViewById<TextInputLayout>(R.id.til_nombre_perfil)
        val til_correo_perfil = findViewById<TextInputLayout>(R.id.til_correo_perfil)
        val til_max_cal_perfil = findViewById<TextInputLayout>(R.id.til_max_cal_perfil)
        var nombre_perfil = til_nombre_perfil.editText?.text.toString()
        var correo_perfil = til_correo_perfil.editText?.text.toString()
        var max_cal_perfil = til_max_cal_perfil.editText?.text.toString()

        val validarPerfil = Validate()
        if(validarPerfil.validarCampoNulo(nombre_perfil)) {
            til_nombre_perfil.error = "No puede dejar el campo vacio!"
            contNombrePerfil++
        }
        else {
            til_nombre_perfil.error = ""
        }
        if(validarPerfil.validarCampoNulo(correo_perfil)) {
            til_correo_perfil.error = "No puede dejar el campo vacio!"
            contCorreoPerfil++
        }
        else {
            til_correo_perfil.error = ""
        }
        if(validarPerfil.validarCampoNulo(max_cal_perfil)) {
            til_max_cal_perfil.error = "No puede dejar el campo vacio!"
            contMaxCalPerfil++
        }else {
            til_max_cal_perfil.error = ""
        }

        if(contCorreoPerfil == 0) {
            if(!validarPerfil.validateFormCorreo(correo_perfil)) {
                til_correo_perfil.error = "El Correo no posee el formato correcto"
                contCorreoPerfil++
            } else {
                til_correo_perfil.error = ""
            }
        }

        contFinalPerfil = contNombrePerfil + contCorreoPerfil + contMaxCalPerfil

        return contFinalPerfil
    }

}