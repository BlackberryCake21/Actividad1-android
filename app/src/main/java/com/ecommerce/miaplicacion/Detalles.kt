package com.ecommerce.miaplicacion

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
// Composable que representa la pantalla de detalle
// Recibe los parámetros que fueron pasados desde la pantalla anterior: imagen, título y descripción
@Composable
fun detalle(navController: NavController, imagen: Int, titulo: String, descripcion: String) {

    // Variable de estado que controla si se muestra el diálogo (imagen ampliada)
    var mostrarDialogo by remember { mutableStateOf(false) }

    // Estructura principal de la pantalla con barras superior e inferior
    Scaffold(

        // Barra superior con el título recibido por parámetro
        topBar = {
            TopAppBar(
                title = { Text(titulo) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        },

        // Barra inferior con un botón para volver atrás
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.height(100.dp)
            ) {
                // Contenedor centrado para el botón "Volver"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        // Al presionar, se quita la pantalla actual del stack de navegación
                        onClick = { navController.popBackStack() },
                    ) {
                        Text("Volver")
                    }
                }
            }
        },

        // Color de fondo del Scaffold
        containerColor = MaterialTheme.colorScheme.background,

    ) { // Contenido principal de la pantalla

        // Lista vertical que permite desplazamiento (aunque haya solo un elemento)
        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            // Primer elemento: imagen principal
            item {
                Box(
                    modifier = Modifier
                        .width(400.dp)
                        .padding(top = 120.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Muestra la imagen circular
                    Image(
                        painter = painterResource(id = imagen),
                        contentDescription = "Primera imagen",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .clip(CircleShape) // Imagen redondeada
                            .size(250.dp)
                            // Al hacer clic sobre la imagen, se abre el diálogo con la imagen ampliada
                            .clickable { mostrarDialogo = true }
                    )
                }
            }

            // Segundo elemento: texto descriptivo y diálogo emergente
            item {
                // Muestra la descripción debajo de la imagen
                Text(
                    text = descripcion,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, top = 30.dp, bottom = 100.dp, end = 30.dp)
                )

                // Si 'mostrarDialogo' es true, se muestra el diálogo con la imagen ampliada
                if (mostrarDialogo) {
                    Dialog(onDismissRequest = { mostrarDialogo = false }) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                // Si se toca fuera del área de la imagen, el diálogo se cierra
                                .clickable { mostrarDialogo = false },
                            contentAlignment = Alignment.Center,
                        ) {
                            // Imagen ampliada en el centro del diálogo
                            Image(
                                painter = painterResource(id = imagen),
                                contentDescription = titulo,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp)) // Bordes redondeados
                            )
                        }
                    }
                }
            }
        }
    }
}


