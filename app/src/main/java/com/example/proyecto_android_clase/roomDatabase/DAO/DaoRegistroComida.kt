package com.example.proyecto_android_clase.roomDatabase.DAO

import androidx.room.Dao
import androidx.room.Query
import com.example.proyecto_android_clase.roomDatabase.entity.RegistroComida

@Dao
interface DaoRegistroComida {
    @Query("Select * from RegistroComida")
    suspend fun obtenerRegistros(): List<RegistroComida>

}