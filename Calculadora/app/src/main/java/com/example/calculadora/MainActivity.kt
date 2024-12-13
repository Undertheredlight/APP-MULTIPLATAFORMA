package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //capturamos todos nuestros componentes con el

        val edtN1 = findViewById<EditText>(R.id.edtN1)
        val edtN2 = findViewById<EditText>(R.id.edtN2)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularSuma)
        val textResultado = findViewById<TextView>(R.id.textResultado)


        btnCalcular.setOnClickListener {
            val n1 = edtN1.text.toString().toInt()
            val n2 = edtN2.text.toString().toInt()
            val res = n1 + n2
            textResultado.text = "Relsultado: ${res.toString()}"

        }



        }
    }
