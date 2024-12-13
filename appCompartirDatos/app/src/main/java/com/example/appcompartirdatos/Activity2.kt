package com.example.appcompartirdatos

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //cuando viene onCreate viene con el formato Bundle?
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)

        //coge un bundle de tipo bundle. La interrogacion es para que no falle
        val bundle:Bundle ?= intent.extras

        //creamos una variable para recoger el valor del intent
        val mensaje2:String ?= bundle!!.getString("envio")
        //val mensaje2 = bundle!!.getString("envio")

        //Toast.makeText(this,mensaje2,Toast.LENGTH_LONG).show()

        //recogemos el componente
        val txtIntent = findViewById<TextView>(R.id.txtIntent)
        txtIntent.text = mensaje2


    }
}