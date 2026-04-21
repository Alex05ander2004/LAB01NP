package com.example.lab01np

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab01np.ui.theme.LAB01NPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LAB01NPTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    PantallaPrincipal(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class Tarea(
    val titulo: String,
    val descripcion: String
)

@Composable
fun PantallaPrincipal(modifier: Modifier = Modifier) {

    var mensaje by remember { mutableStateOf("") }

    val tareas = listOf(
        Tarea(
            titulo = "Comprar víveres",
            descripcion = "Comprar frutas, leche y pan"
        ),
        Tarea(
            titulo = "Estudiar Compose",
            descripcion = "Revisar LazyColumn, Card y Button"
        ),
        Tarea(
            titulo = "Hacer ejercicio",
            descripcion = "Correr durante 30 minutos"
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "LAB01NP",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Aplicación creada con Jetpack Compose",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                mensaje = "¡Botón presionado!"
            }
        ) {
            Text(text = "Mostrar mensaje")
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (mensaje.isNotEmpty()) {
            Text(
                text = mensaje,
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Lista de tareas",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(tareas) { tarea ->
                ItemCard(tarea = tarea)
            }
        }
    }
}

@Composable
fun ItemCard(tarea: Tarea) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        ContenidoItem(tarea = tarea)
    }
}

@Composable
fun ContenidoItem(tarea: Tarea) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        TituloItem(texto = tarea.titulo)

        Spacer(modifier = Modifier.height(8.dp))

        DescripcionItem(texto = tarea.descripcion)
    }
}

@Composable
fun TituloItem(texto: String) {
    Text(
        text = texto,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DescripcionItem(texto: String) {
    Text(
        text = texto,
        fontSize = 16.sp,
        color = Color.DarkGray
    )
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview() {
    LAB01NPTheme {
        PantallaPrincipal()
    }
}