package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val  btnToast = findViewById<Button>(R.id.btnToast)

        btnToast.setOnClickListener {//para que el botón haga algo usamos este
            Log.i("MainActivity","Botón pulsado")

            Toast.makeText(this,"Calculando..",Toast.LENGTH_SHORT).show()
        }


        }
    }
