package com.example.apptarjetavisita

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apptarjetavisita.ui.theme.AppTarjetaVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTarjetaVisitaTheme {
                //Surface es el contenedor
                Surface(color = MaterialTheme.colorScheme.primaryContainer, contentColor = MaterialTheme.colorScheme.primary) {
                    crearTarjetaVisita()
                }
            }
        }
    }
}

//creamos una funcion tarjetaVisita
@Composable
fun crearTarjetaVisita(){
    val estadoDelBoton = remember{
        mutableStateOf(false)
    }
    Surface(modifier = Modifier.fillMaxWidth().fillMaxSize()){
        Card (modifier = Modifier.width(200.dp).height(390.dp).padding(15.dp),
            shape = RoundedCornerShape(corner = CornerSize(50.dp)),
            colors =  CardDefaults.cardColors(
                //tambien puede ser containerColor = color.red
                containerColor = MaterialTheme.colorScheme.scrim
            ),
            elevation = CardDefaults.cardElevation(5.dp)
        )
        {
         Column(modifier = Modifier.height(500.dp).width(500.dp).padding(20.dp),
             verticalArrangement = Arrangement.Top,
             horizontalAlignment = Alignment.CenterHorizontally)
         {
             fotoPerfil()
             HorizontalDivider(thickness = 5.dp)
             Button(
                 onClick = {
                     estadoDelBoton.value = !estadoDelBoton.value
                 }
             ) {
                 Text("Portfolio", style = MaterialTheme.typography.labelLarge)
             }
         }
            if(estadoDelBoton.value){
                Contenido()
            }else{
                Box(){

                }
            }

        }
    }
}


@Preview
@Composable
fun Contenido(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxSize().padding(5.dp)){
        Surface (modifier = Modifier.padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.Gray)
        )
        {
            //lista de cosas
            Portfolio(data = listOf("Proyecto 1", "Proyecto 2", "Proyecto 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data){ item->
                Card(modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                    shape = RectangleShape,
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.inverseSurface
                    ))
                {
                    Row (modifier = Modifier.padding(8.dp)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(16.dp))
                    {
                        fotoPerfil(modifier = Modifier.size(100.dp))
                        Column (modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)){
                            Text(text = item, fontWeight = FontWeight.Bold)
                            Text(text = "Mazo de currado", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
        }
    }
}


@Composable
private fun infoPerfil() {
    Text(
        text = "Liz Andreina Contreras Hernandez",
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.surfaceDim,
        textAlign = TextAlign.Center
    )
    Text(
        text = "Estudiante de Programación",
        modifier = Modifier.padding(3.dp),
        color = MaterialTheme.colorScheme.surfaceDim
    )

    Text(
        text = "@Develolizi",
        modifier = Modifier.padding(3.dp),
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.surfaceDim
    )
}

@Composable
private fun fotoPerfil(modifier: Modifier=Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.foto),
            contentDescription = "Imagen de perfil",
            modifier = Modifier.size(10.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable //vete a la libreria y coge todo
fun GreetingPreview() {
    AppTarjetaVisitaTheme {
    crearTarjetaVisita()
    }
}