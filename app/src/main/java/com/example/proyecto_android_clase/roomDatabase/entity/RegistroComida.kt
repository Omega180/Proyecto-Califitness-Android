package com.example.proyecto_android_clase.roomDatabase.entity


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = TipoComida::class,
        parentColumns = arrayOf("id_tipo_comida"),
        childColumns = arrayOf("FK_tipo_comida"),
        onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = Usuario::class,
        parentColumns = arrayOf("usuario"),
        childColumns = arrayOf("FK_Usuario"),
        onDelete = ForeignKey.CASCADE
    )
) )
class RegistroComida {

        @PrimaryKey(autoGenerate = true)
        var id:Long=0
        var nombre_comida: String? = null
        var cant_calorias: String? = null
        var fecha: String? = null
        var favoritos_SiNo: Boolean? = false
        var FK_tipo_comida: Int = 0
        var FK_Usuario: String? = null

    constructor(
        nombre_comida: String?,
        cant_calorias: String?,
        fecha: String?,
        favoritos_SiNo: Boolean?,
        FK_tipo_comida: Int,
        FK_Usuario: String
    ) {
        this.nombre_comida = nombre_comida
        this.cant_calorias = cant_calorias
        this.fecha = fecha
        this.favoritos_SiNo = favoritos_SiNo
        this.FK_tipo_comida = FK_tipo_comida
        this.FK_Usuario = FK_Usuario
    }


    override fun toString(): String {
            return "RegistroComida(id=$id, nombre_comida=$nombre_comida, cant_calorias=$cant_calorias, fecha=$fecha, favoritos_SiNo=$favoritos_SiNo, FK_tipo_comida=$FK_tipo_comida, FK_Usuario=$FK_Usuario)"
        }

    }