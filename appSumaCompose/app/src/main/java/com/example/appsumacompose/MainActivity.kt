package com.example.appsumacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import com.example.appsumacompose.ui.theme.AppSumaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppSumaComposeTheme {
               MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Fondo negro en toda la pantalla y que no se vea blanco arriba
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp), // Ajusta según la altura deseada
            color = MaterialTheme.colorScheme.scrim
        ) {
            var entrada1 by remember { mutableStateOf("") }
            var entrada2 by remember { mutableStateOf("") }
            var resultado by remember { mutableStateOf(0.0) }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(0.dp) // Padding interno para el contenido
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Introduce el número 1",
                        color = Color.White,
                        modifier = Modifier.weight(1f) // Espacio proporcional para el texto
                    )
                    TextField(
                        value = entrada1,
                        onValueChange = { entrada1 = it },
                        label = { Text("") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.width(100.dp) // Ancho del TextField
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Introduce el número 2",
                        color = Color.White,
                        modifier = Modifier.weight(1f) // Espacio proporcional para el texto
                    )
                    TextField(
                        value = entrada2,
                        onValueChange = { entrada2 = it },
                        label = { Text("") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.width(100.dp) // Ancho del TextField
                    )
                }
                Row(modifier = Modifier.padding(16.dp)) {
                    Button(
                        modifier = Modifier.padding(5.dp),
                        onClick = { resultado = entrada1.toDouble() + entrada2.toDouble() },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                    ) {
                        Text("Sumar", modifier = Modifier.padding(5.dp))
                    }
                    Button(
                        modifier = Modifier.padding(5.dp),
                        onClick = { resultado = entrada1.toDouble() - entrada2.toDouble() },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                    ) {
                        Text("Resultado ${resultado}", modifier = Modifier.padding(5.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreeliminar() {
    AppSumaComposeTheme {
        MyApp()
    }
}