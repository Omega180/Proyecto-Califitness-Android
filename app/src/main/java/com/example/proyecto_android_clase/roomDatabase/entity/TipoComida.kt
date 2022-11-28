package com.example.proyecto_android_clase.roomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TipoComida {
    @PrimaryKey(autoGenerate = true)
    var id_tipo_comida: Int = 0
    var tipo_comida: String? = null

    constructor(id_tipo_comida: Int, tipo_comida: String?) {
        this.id_tipo_comida = id_tipo_comida
        this.tipo_comida = tipo_comida
    }

    override fun toString(): String {
        return "tipo_comida(id_tipo_comida=$id_tipo_comida, tipo_comida=$tipo_comida)"
    }


}