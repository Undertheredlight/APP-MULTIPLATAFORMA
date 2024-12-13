package com.example.appecuacioncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appecuacioncompose.ui.theme.AppEcuacionComposeTheme
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppEcuacionComposeTheme {
                    MyApp()
                }
            }
        }
    }

@Composable
fun MyApp() {
    var a by remember { mutableStateOf("") }
    var b by remember { mutableStateOf("") }
    var c by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") } // Mensaje de error

    //este box lo pongo para meter todo dentro de una caja y que el fondo sea de color negro
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Fondo negro en toda la pantalla y que no se vea blanco arriba
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp), // Ajustamos el padding para que no esté tan pegado
                color = Color.Black
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                // Entrada para el coeficiente 'a'
                Row(modifier = Modifier.padding(16.dp)) {
                    Text("Coeficiente a:", //texto que aparece
                        color = Color.White, //color del texto
                        modifier = Modifier.weight(1f)) // Espacio entre el text y textfield
                    TextField(
                        value = a, //indicamos que va el valor de la variable a
                        onValueChange = { a = it },
                        label = { Text("") }, //sin texto para que la persona escriba dentro
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.width(70.dp) //tamaño de la caja del textField
                    )
                }

                // Entrada para el coeficiente 'b'
                Row(modifier = Modifier.padding(16.dp)) {
                    Text("Coeficiente b:",
                        color = Color.White,
                        modifier = Modifier.weight(1f))
                    TextField(
                        value = b,
                        onValueChange = { b = it },
                        label = { Text("") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.width(70.dp)
                    )
                }

                // Entrada para el coeficiente 'c'
                Row(modifier = Modifier.padding(16.dp)) {
                    Text("Coeficiente c:", color = Color.White,modifier = Modifier.weight(1f))
                    TextField(
                        value = c,
                        onValueChange = { c = it },
                        label = { Text("") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.width(70.dp)
                    )
                }

                // Botón para calcular la ecuación de segundo grado
                Button(
                    onClick = {
                        // Limpiar el mensaje de error cuando se presiona el botón
                        error = ""

                        // Validar que los coeficientes sean números
                        try {
                            val aVal = a.toDouble()
                            val bVal = b.toDouble()
                            val cVal = c.toDouble()

                            // Validación: a no puede ser 0
                            if (aVal == 0.0) {
                                error = "El coeficiente 'a' no puede ser 0."
                                return@Button
                            }

                            val discriminante = bVal * bVal - 4 * aVal * cVal

                            // Si el discriminante es mayor a cero, hay dos raíces reales
                            if (discriminante > 0) {
                                val x1 = (-bVal + sqrt(discriminante)) / (2 * aVal)
                                val x2 = (-bVal - sqrt(discriminante)) / (2 * aVal)
                                resultado = "Raíz 1: $x1, Raíz 2: $x2"
                            }
                            // Si el discriminante es igual a cero, hay una raíz real doble
                            else if (discriminante == 0.0) {
                                val x = -bVal / (2 * aVal)
                                resultado = "Raíz única: $x"
                            }
                            // Si el discriminante es menor a cero, las raíces son complejas
                            else {
                                val real = -bVal / (2 * aVal)
                                val imaginario = sqrt(-discriminante) / (2 * aVal)
                                resultado = "Raíces complejas: $real ± ${imaginario}i"
                            }
                        } catch (e: NumberFormatException) {
                            // Capturar el error si no es un número válido
                            error = "Por favor, ingresa valores numéricos válidos."
                        }
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Calcular Raíces", color = Color.White)
                }

                Text(
                    text = resultado,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge, // Cambiado de h6 a titleLarge
                    modifier = Modifier.padding(16.dp)
                )

                // Mostrar el mensaje de error si existe
                if (error.isNotEmpty()) {
                    Text(
                        text = error,
                        color = Color.Red,
                        style = MaterialTheme.typography.bodyMedium, // Cambiado de body1 a bodyMedium
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreeliminar() {
    AppEcuacionComposeTheme {
        MyApp()
    }
}