package com.example.otraappcomposepruebas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.otraappcomposepruebas.ui.theme.OtraAppComposePruebasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OtraAppComposePruebasTheme {
                NavegarApp()
            }
        }
    }
}


@Composable
fun MyApp(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Button (
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                onClick ={navController.navigate("detalles")}
            ) { Text("Pulsame") }
        }
    }
}


@Composable
fun NavegarApp(){
    val controladorNavegacion= rememberNavController()
    NavHost(navController = controladorNavegacion, startDestination = "inicio"){
        composable("inicio"){ MyApp(controladorNavegacion)}
        composable("detalles"){ DetallesProducto(controladorNavegacion)}
    }
}




@Composable
fun DetallesProducto(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.secondary) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Esto son los detalles cuando pinchas el botón")
            Button(onClick = {navController.popBackStack()}) {
                Text("Volver")
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    OtraAppComposePruebasTheme {
        NavegarApp()
    }
}