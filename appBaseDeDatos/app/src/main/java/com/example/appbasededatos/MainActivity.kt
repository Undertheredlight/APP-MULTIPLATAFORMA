package com.example.appbasededatos

import android.content.ContentValues
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appbasededatos.ui.theme.AppBaseDeDatosTheme


class MainActivity : ComponentActivity() {
    private lateinit var ayudanteBaseDatos: AyudanteBaseDatos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inicializa el ayudante de base de datos
        ayudanteBaseDatos = AyudanteBaseDatos(this)
        setContent {
            AppBaseDeDatosTheme {
                MiApp(ayudante = ayudanteBaseDatos)
            }
        }
    }
}


fun insertarUsuario(ayudante: AyudanteBaseDatos, nombre:String, correo: String): Long{
    val db = ayudante.writableDatabase //variable que se encarga de escribir y le indico que lo abra como escritura
    val valores = ContentValues().apply{
        put(AyudanteBaseDatos.COLUMNA_NOMBRE,nombre)
        put(AyudanteBaseDatos.COLUMNA_CORREO,correo)
    }
   return db.insert(AyudanteBaseDatos.TABLA_USUARIOS,null,valores)
}

fun eliminarUsuario(ayudante: AyudanteBaseDatos, id: Int): Int{
    val db = ayudante.writableDatabase
    return db.delete(
        AyudanteBaseDatos.TABLA_USUARIOS,"${AyudanteBaseDatos.COLUMNA_ID} = ?",
        arrayOf(id.toString())
    )
}

fun actualizarUsuario(ayudante: AyudanteBaseDatos, id: Int,nombre: String, correo: String):Int {
    val db = ayudante.writableDatabase
    val valores = ContentValues().apply {
        put(AyudanteBaseDatos.COLUMNA_NOMBRE, nombre)
        put(AyudanteBaseDatos.COLUMNA_CORREO, correo)
    }
    return db.update(
        AyudanteBaseDatos.TABLA_USUARIOS,
        valores,
        "${AyudanteBaseDatos.COLUMNA_ID} = ?",
        arrayOf(id.toString())
    )
}

fun obtenerTodosLosUsuarios(ayudante: AyudanteBaseDatos): List<Triple<Int, String, String>>{
    val db = ayudante.readableDatabase
    val cursor = db.query(
        AyudanteBaseDatos.TABLA_USUARIOS,
        arrayOf(AyudanteBaseDatos.COLUMNA_ID, AyudanteBaseDatos.COLUMNA_NOMBRE, AyudanteBaseDatos.COLUMNA_CORREO),
        null,null,null,null,null)

    val usuarios = mutableListOf<Triple<Int,String,String>>()
    while (cursor.moveToNext()){
        val id = cursor.getInt(cursor.getColumnIndexOrThrow(AyudanteBaseDatos.COLUMNA_ID))
        val nombre = cursor.getString(cursor.getColumnIndexOrThrow(AyudanteBaseDatos.COLUMNA_NOMBRE))
        val correo = cursor.getString(cursor.getColumnIndexOrThrow(AyudanteBaseDatos.COLUMNA_CORREO))
        usuarios.add(Triple(id, nombre, correo))
    }
    cursor.close()
    return usuarios
}


@Composable
fun MiApp(ayudante: AyudanteBaseDatos) {

}
