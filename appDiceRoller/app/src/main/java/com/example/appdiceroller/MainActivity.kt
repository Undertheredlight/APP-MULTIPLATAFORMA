package com.example.appdiceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener { rollDice() }
        rollDice()

    }
    private fun rollDice() {
        //Creamos un nuevo objeto Dice con 6 lados
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Encuentra la imagen en el layaout
        val diceImage:ImageView  = findViewById(R.id.imageView)

        //Determina cuál drawable  se usara
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Descargamos la imagen
        diceImage.setImageResource(drawableResource)

        //Actualizamos la descripción del contenido
        diceImage.contentDescription = diceRoll.toString()
    }
}