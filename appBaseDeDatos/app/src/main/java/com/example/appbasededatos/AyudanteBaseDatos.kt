package com.example.appbasededatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AyudanteBaseDatos (context: Context)
    : SQLiteOpenHelper (context, NOMBRE_BBDD, null, VERSION_BBDD) {
    companion object {
        private const val NOMBRE_BBDD="empresa.db"
        private const val VERSION_BBDD=1
        const val TABLA_USUARIOS="usuarios"
        const val COLUMNA_ID="id"
        const val COLUMNA_NOMBRE="nombre"
        const val COLUMNA_CORREO="correo"
    }


    override fun onCreate(db: SQLiteDatabase) {
        val consultaCrearTabla = """
            CREATE TABLE $TABLA_USUARIOS(
            $COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMNA_NOMBRE TEXT NOT NULL, 
            $COLUMNA_CORREO TEXT NOT NULL)
        """
        db.execSQL(consultaCrearTabla)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //por simplicidad borramos la bbdd si existe
        db.execSQL("DROP TABLE IF EXISTS $TABLA_USUARIOS")
        onCreate(db)
    }

}
