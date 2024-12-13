package com.example.apppro

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.internal.Intrinsics.Kotlin
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //cogemos nuestro boton para eso hay que buscarlo, declaramos variable y lo llamamos
        //val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        //Metemos el listener runa vez que lo tenemos
        /*
        btnCalcular.setOnClickListener {
            /*dentro onlicklistener capturamos todo lo que necesitamos para trabajar*/

            val edtPrecio = findViewById<EditText>(R.id.edtPrecio)
            val sRedondeo = findViewById<Switch>(R.id.sRedondeo)
            val txtTotal = findViewById<TextView>(R.id.txtTotal)
            val rG1 = findViewById<RadioGroup>(R.id.rG1)
            val rB20 = findViewById<RadioButton>(R.id.rB20)
            val rB18 = findViewById<RadioButton>(R.id.rB18)
            val rB15 = findViewById<RadioButton>(R.id.rB15)

            val porcentaje : Double
            //lo que le estoy diciendo es que del grupo1 compuerba que id se a seleccionado y si es el 20 haz una cosa y asi sucesivamente
            if(rG1.checkedRadioButtonId == R.id.rB20){
                porcentaje = 1.2
            }else if(rG1.checkedRadioButtonId == R.id.rB20){
                porcentaje = 1.18
            }else{
                porcentaje = 1.15
            }

            var subTotal = edtPrecio.text.toString().toDouble()*porcentaje

            if(sRedondeo.isChecked){
                subTotal = ceil(subTotal)

            }

            txtTotal.setText(subTotal.toString())

        }*/

    }
}