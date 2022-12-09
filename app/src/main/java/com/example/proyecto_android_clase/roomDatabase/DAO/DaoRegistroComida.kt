package com.example.proyecto_android_clase.roomDatabase.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.proyecto_android_clase.roomDatabase.entity.RegistroComida

@Dao
interface DaoRegistroComida {

    @Query("SELECT * FROM RegistroComida")
    suspend fun obtenerRegistroComida():List<RegistroComida>

    @Query("SELECT * FROM RegistroComida WHERE FK_Usuario=:FK_Usuario")
    suspend fun obtenerComidasUsuario(FK_Usuario: String): List<RegistroComida>

    @Query("SELECT * FROM RegistroComida WHERE nombre_comida=:nombre_comida AND FK_Usuario=:FK_Usuario")
    suspend fun obtenerComidaporNombre(nombre_comida: String,FK_Usuario: String): List<RegistroComida>

    @Query("SELECT * FROM RegistroComida WHERE FK_Usuario=:FK_Usuario AND fecha=:fecha AND FK_tipo_comida=:FK_tipo_comida")
    suspend fun obtenerComidaCreada(FK_Usuario: String,fecha: String,FK_tipo_comida: String): List<RegistroComida>

    @Insert
    suspend fun agregarRegistroComida(registroComida: RegistroComida): Long

    @Query("UPDATE RegistroComida SET nombre_comida=:nombre_comida,cant_calorias=:cant_calorias,favoritos_SiNo=:favoritos_SiNo WHERE FK_Usuario=:FK_Usuario AND fecha=:fecha AND FK_tipo_comida=:FK_tipo_comida")
    suspend fun actualizarRegistroComida(nombre_comida: String, cant_calorias: String, favoritos_SiNo: Boolean, FK_Usuario: String, fecha: String, FK_tipo_comida: String)

    @Query("DELETE FROM RegistroComida WHERE FK_Usuario=:FK_Usuario AND fecha=:fecha AND FK_tipo_comida=:FK_tipo_comida")
    suspend fun borrarComida(FK_Usuario: String, fecha: String, FK_tipo_comida: String)


}