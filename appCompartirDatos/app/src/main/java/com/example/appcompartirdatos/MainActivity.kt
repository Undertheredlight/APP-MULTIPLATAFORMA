package com.example.appcompartirdatos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtMensaje = findViewById<EditText>(R.id.edtMensaje)


        val btnDirecto = findViewById<Button>(R.id.btnDirecto)
        btnDirecto.setOnClickListener {
            val mensaje : String = edtMensaje.text.toString() //guardamos el mensaje, el contenido
            //Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()

            //con el this me refiero a donde estoy ahora y luego le indico que dentro de activity2 te vas a la clase java
            val intent = Intent(this,Activity2::class.java)

            //le que le voy a mandar se llama envio
            intent.putExtra("envio",mensaje)

            //quiero lanzar la actividad con un intent
            startActivity(intent)
        }

        val btnElige = findViewById<Button>(R.id.btnElige)
        btnElige.setOnClickListener {
            val mensaje : String = edtMensaje.text.toString() //guardamos el mensaje, el contenido
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()

            //en vez de lanzarlo directamente le decimos que lo construya con el constructor por defecto
            //le lanzamos el mensaje puro
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,mensaje)
            intent.type = "text/plain" //que tipo de dato vamos a enviar?? textplain
            startActivity(Intent.createChooser(intent,"hola"))
        }

    }
}