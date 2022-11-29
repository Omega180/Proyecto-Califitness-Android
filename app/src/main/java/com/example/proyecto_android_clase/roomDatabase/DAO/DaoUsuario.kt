package com.example.proyecto_android_clase.roomDatabase.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.proyecto_android_clase.roomDatabase.entity.Usuario

@Dao
interface DaoUsuario {
    //El nombre de la entidad debe calzar con el nombre de la tabla
    @Query("SELECT * FROM Usuario")
    //el suspend son las corrutionas
    //arreglo de Usuarios
    suspend fun obtenerUsuarios():List<Usuario>
    @Query("SELECT * From Usuario Where Usuario=:usuario")
    suspend fun obtenerUsuario(usuario: String): List<Usuario>


    @Query("SELECT * FROM Usuario WHERE Usuario=:usuario AND contrasena=:contrasena")
    suspend fun login(usuario: String, contrasena: String): List<Usuario>
    @Insert
    suspend fun agregarUsuario(usuario: Usuario):Long


    //=: nos permite parametrizar
    @Query("UPDATE Usuario SET nombre=:nombre , contrasena=:contrasena WHERE Usuario=:usuario")
    suspend fun actualizarUsuario(nombre:String, usuario: String, contrasena: String): Int


    @Query("DELETE FROM Usuario Where Usuario=:usuario")
    suspend fun borrarUsuario(usuario:String)


}