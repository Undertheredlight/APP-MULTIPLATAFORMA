package com.example.formulas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val btnCuadrado = findViewById<Button>(R.id.btnCuadrado)
        val edtLadoCua = findViewById<EditText>(R.id.edtLadoCua)


        btnCuadrado.setOnClickListener {
            val mensaje : Double = edtLadoCua.text.toString().toDouble();
            val intent = Intent(this,CuadradoActivity::class.java)
            intent.putExtra("envio",mensaje)
            startActivity(intent)
        }

        val btnTriangulo = findViewById<Button>(R.id.btnTriangulo)
        val edtBaseTri = findViewById<EditText>(R.id.edtBaseTri)
        val edtLadoTri = findViewById<EditText>(R.id.edtLadoTri)
        btnTriangulo.setOnClickListener {
            val mensaje1 : Double = edtBaseTri.text.toString().toDouble();
            val mensaje2 : Double = edtLadoTri.text.toString().toDouble();
            val intent = Intent(this,TrianguloActivity::class.java)
            intent.putExtra("envio",mensaje1)
            intent.putExtra("envio",mensaje2)
            startActivity(intent)
        }

        val btnCirculo = findViewById<Button>(R.id.btnCirculo)
        val edtAreaCir = findViewById<EditText>(R.id.edtAreaCir)
        btnCirculo.setOnClickListener {
            val mensaje : Double = edtAreaCir.text.toString().toDouble();
            val intent = Intent(this,CirculoActivity::class.java)
            intent.putExtra("envio",mensaje)
            startActivity(intent)
        }
    }
}