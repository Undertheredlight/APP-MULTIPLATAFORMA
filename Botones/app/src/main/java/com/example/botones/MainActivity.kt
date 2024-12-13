package com.example.botones

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txt1 = findViewById<TextView>(R.id.txtMensaje1)
        val txt2 = findViewById<TextView>(R.id.txtMensaje2)
        val txt3 = findViewById<TextView>(R.id.txtMensaje3)
        val btnBlue = findViewById<Button>(R.id.btnBlue)
        val btnTog = findViewById<ToggleButton>(R.id.btnToogle)
        val btnSwitch = findViewById<Switch>(R.id.btnSwitch)

        //Para verificar estado del ToggleButton con isChecked
        btnTog.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txt1.text = "El Toggle está activado"
                txt2.text = ""
            }else {
                txt1.text = ""
                txt2.text = "El Toggle está desactivado"
            }
        }

        btnBlue.setOnClickListener{
            txt3.text = "Botón Bluetooth presionado"
        }

        btnSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txt1.text = "Conexión: Activada"
                txt2.text = ""
            } else {
                txt2.text = "Conexión: Desactivada"
                txt1.text = ""
            }
        }

    }
}