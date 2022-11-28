package com.example.proyecto_android_clase.roomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Anotaciones
Para que se detecten qué clases tendrán que ser tratadas por esta librería y para indicar ciertas configuraciones debemos utilizar anotaciones. Las principales son las siguientes:
@Database: para indicar que la clase será el Database. Además, dicha clase debería ser abstracta y heredar de RoomDatabase.
@Dao: se utiliza para las interfaces de los DAOs.
@Entity: indica que la clase es una entidad.
@PrimaryKey: indica que el atributo al que acompaña será la clave primaria de la tabla. También podemos establecer que se asigne automáticamente si la incluimos así: @PrimaryKey(autoGenerate = true)».
@ColumnInfo: sirve para personalizar la columna de la base de datos del atributo asociado. Podemos indicar, entre otras cosas, un nombre para la columna diferente al del atributo.
@Ignore: previene que el atributo se almacene como campo en la base de datos.
@Index: para indicar el índice de la entidad.
@ForeingKey: indica que el atributo es una clave foránea relacionada con la clave primaria de otra entidad.
@Embedded: para incluir una entidad dentro de otra.
@Insert: anotación para los métodos de los DAOs que inserten en la base de datos.
@Delete: anotación para los métodos de los DAOs que borren en la base de datos.
@Update: anotación para los métodos de los DAOs que actualicen una entidad en la base de datos.
@Query: anotación para un método del DAO que realice una consulta en la base de datos, la cual deberemos especificar.
 * */
//Cuando se define como entidad
@Entity

class Usuario {
    @PrimaryKey
    var usuario: String
    var nombre: String? = null
    var contrasena: String? = null
    var fecha_nacimiento: String? = null

    constructor(
        usuario: String,
        nombre: String?,
        contrasena: String?,
        fecha_nacimiento: String?
    ) {
        this.usuario = usuario
        this.nombre = nombre
        this.contrasena = contrasena
        this.fecha_nacimiento = fecha_nacimiento
    }

    override fun toString(): String {
        return "Usuario(usuario='$usuario', nombre=$nombre, contraseña=$contrasena, fecha_nacimiento=$fecha_nacimiento)"
    }


}