package com.example.appdiseo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appdiseo.ui.theme.AppDiseñoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppDiseñoTheme {
                    Miapp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Miapp() {
    Scaffold (
        topBar = { TopAppBar(title = { Text("Barra Superior")},
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary)
        )},
        bottomBar = { BottomAppBar(){ Text("Barra Inferior")}},
        floatingActionButton = {
            FloatingActionButton(onClick = { }){
                Icon(Icons.Filled.AddCircle, contentDescription = "Check")
            }
        },
        content = {padding ->
                Surface(
                    modifier = Modifier.fillMaxSize().padding(padding),
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.primary,
                    shadowElevation = 10.dp,
                    border = BorderStroke(3.dp, Color.Black)
                ) {
                    Column (modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Text("Liz Andreina Contreras",
                            color = Color.Black,
                            fontSize = 45.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 45.sp
                        )
                        Icon(Icons.Filled.AccountCircle, contentDescription = "Careta",
                            modifier = Modifier.width(50.dp).height(50.dp))

                        val texto by remember {mutableStateOf("") }

                        TextField(texto, onValueChange = {/*ACCIÓN*/},
                            label = {Text("Datos")})
                    }
                }
        }
    )
}
/*
                Surface(
                    modifier = Modifier.fillMaxSize().padding(padding),
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.primary,
                    shadowElevation = 10.dp,
                    border = BorderStroke(3.dp, Color.Black)
                ) {
                    Column(modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally){
                        Text("Hola a todos")
                        Text("¿Cómo están ustedes?")
                    }
                    Row (modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically){
                        Text("Payasos de la Tele")
                        Column(modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Hola a todos")
                            Text("¿Cómo están ustedes?")
                        }
                    }
                    Box(){
                        Text("de la tela")
                        Icon(Icons.Filled.Check, contentDescription = "Check")
                    }
                }
 */



@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    AppDiseñoTheme {
        Miapp()
    }
}