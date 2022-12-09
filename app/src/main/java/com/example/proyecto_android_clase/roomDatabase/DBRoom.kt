package com.example.proyecto_android_clase.roomDatabase

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.example.proyecto_android_clase.roomDatabase.DAO.DaoRegistroComida
import com.example.proyecto_android_clase.roomDatabase.DAO.DaoTipo
import com.example.proyecto_android_clase.roomDatabase.DAO.DaoUsuario
import com.example.proyecto_android_clase.roomDatabase.entity.RegistroComida
import com.example.proyecto_android_clase.roomDatabase.entity.TipoComida
import com.example.proyecto_android_clase.roomDatabase.entity.Usuario

@Database(
    entities = [Usuario::class, TipoComida::class, RegistroComida::class],
    version = 1,
)

abstract class  DBRoom:RoomDatabase() {
    abstract fun daoUsuario():DaoUsuario
    abstract fun daoRegistroComida():DaoRegistroComida
    abstract fun daoTipo():DaoTipo
}