package com.ecommerce.miaplicacion

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import com.ecommerce.miaplicacion.ui.theme.blanco
import kotlin.collections.get


@Composable
fun inicio(navController : NavController){
    app(navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
// Pantalla inicial de la aplicación
@Composable
fun inicio(navController: NavController) {
    // Llama al composable principal 'app' que contiene la galería
    app(navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun app(navController: NavController) {

    // Definición de un modelo de datos local para representar cada elemento de la galería
    data class Galeria(
        val imagen: Int,        // ID del recurso drawable
        val titulo: String,     // Título de la imagen
        val descripcion: String // Descripción detallada
    )

    // Lista de imágenes con sus títulos y descripciones
    // 'remember' y 'mutableStateListOf' permiten que Compose reactive la interfaz si cambia la lista
    val galeriaImagenes = remember {
        mutableStateListOf(
             Galeria(R.drawable.castilllo,"La Fortaleza Morada sobre Desembarco Púrpura: El Ascenso de los Dragones Púrpura","Esta imagen épica presenta una vasta ciudad portuaria que evoca la arquitectura y el diseño de Desembarco del Rey, pero con una paleta de colores y un nombre distintivos.\n" +  "\n" + "El Corazón de la Ciudad: La Fortaleza Morada\n" + "Estructura Central: Dominando la colina más alta, se alza majestuosamente la Fortaleza Morada, un inmenso castillo de tonos lavanda y malva intenso. Sus murallas son gruesas y almenadas, con múltiples torres que se elevan hacia el cielo, sugiriendo un poderío ancestral. A diferencia de su contraparte carmesí, esta fortaleza irradia un aire de misterio y realeza.\n" + "\n" + "Murallas y Distribución: El castillo está protegido por varias capas de murallas exteriores, de un color morado más sutil, que descienden en terrazas hasta la ciudad baja.\n" + "\n" + "Desembarco Púrpura (La Ciudad)\n" + "Paisaje Urbano: La ciudad se extiende a los pies de la colina, caracterizada por un denso conjunto de casas y edificios de techos de terracota y paredes de piedra clara, típico de una urbe mediterránea o sureña.\n" + "\n" + "Zona Portuaria: En la parte inferior, un bullicioso puerto alberga varios barcos de vela y galeras, indicando un importante centro de comercio marítimo. La bahía azul profundo contrasta con los colores cálidos de la ciudad.\n" + "\n" + "Geografía: La ciudad está enclavada entre colinas verdes y el mar, con otras islas o extensiones de tierra visibles en la distancia, bajo un cielo vasto.\n" + "\n" + "El Cielo y los Señores Alados\n" + "Ambiente y Luz: El momento parece ser el atardecer o el amanecer, con una luz dorada y suave que baña la escena, proyectando sombras largas y acentuando el color púrpura de la fortaleza.\n" + "\n" + "Los Dragones: En el cielo, varios imponentes dragones de escamas verde oliva y marrón están en pleno vuelo. Sus siluetas aladas se recortan contra las nubes hinchadas, que reflejan los tonos anaranjados y rosados del cielo. Los dragones parecen ser guardianes de la Fortaleza Morada, reafirmando el dominio de la casa que rige desde sus murallas."),
            Galeria(R.drawable.avion,"Apocalipsis Urbano: Ecos de la Batalla Final","La imagen presenta una escena desoladora y caótica de una metrópolis moderna sumida en la destrucción total. El cielo, teñido de un ominoso naranja rojizo por las llamas y el humo, crea una atmósfera apocalíptica que envuelve cada rincón de la ciudad.\n" + "\n" + "En el centro de la composición, un imponente avión comercial, envuelto en llamas, se precipita hacia el suelo, dejando una estela de humo negro que se mezcla con el denso velo que cubre el horizonte. Este elemento dramático sugiere un final inminente y catastrófico.\n" + "\n" + "Los rascacielos que alguna vez fueron símbolos de progreso y modernidad, ahora se alzan como esqueletos carbonizados, devorados por un fuego implacable. Las estructuras de acero y concreto se retuercen y colapsan, creando montones de escombros que obstruyen las calles. El humo negro se eleva en columnas gruesas y densas, oscureciendo el ya sombrío paisaje urbano.\n" + "\n" + "Las calles, lejos de ser vías de tránsito, se han transformado en espeluznantes ríos de sangre. El líquido carmesí fluye por las avenidas, rodeando vehículos destrozados y montones de escombros, y reflejando de manera macabra el fuego que consume los edificios. Esta imagen visceral subraya la brutalidad y la escala de la devastación, sugiriendo una batalla sangrienta y sin piedad.\n" + "\n" + "Entre los escombros y a lo largo de los ríos de sangre, se vislumbran siluetas humanas, algunas inmóviles y otras en movimiento, lo que insinúa tanto la pérdida de vidas como la lucha desesperada por la supervivencia. Se pueden apreciar varios vehículos destrozados, volcados y quemados, esparcidos por la ciudad, lo que refuerza la idea de un conflicto armado.\n" + "\n" + "En general, la imagen es una poderosa representación de la guerra y la destrucción, capturando un momento crítico de una batalla final que ha dejado una ciudad moderna irreconocible y convertida en un paisaje de desolación y muerte."),
            Galeria(R.drawable.barco,"El Último Amanecer de los Mares: Invasión desde las Estrellas", "La imagen es una impactante y desoladora representación de un choque de eras, un momento de inminente aniquilación para la humanidad medieval. Un vasto océano, agitado por un viento premonitorio y olas sombrías, está plagado de una flota de cientos de galeras y carabelas de la época medieval. Cada embarcación, con sus velas desplegadas y estandartes ondeando, está abarrotada de guerreros medievales, cuyas armaduras y armas se vislumbran bajo la luz tenue y amenazante. A pesar de su número, la expresión general de la escena es de desesperación y futilidad.\n" + "\n" + "Sobre esta flota ancestral, el cielo está dominado por una fuerza alienígena abrumadora. En el centro, una gigantesca nave nodriza en forma de disco, de diseño futurista y plateado, irradia una luz potente y sobrenatural hacia abajo, creando una columna de energía que parece conectar el cielo con la superficie del mar. Alrededor de esta nave principal, una multitud de naves espaciales más pequeñas, pero igualmente avanzadas, flotan en formación de ataque. Estas naves irradian un brillo azul eléctrico que contrasta fuertemente con la oscuridad del cielo y las profundidades del mar.\n" + "\n" + "El ambiente es de inminente destrucción. Rayos de energía y proyectiles luminosos descienden desde las naves espaciales, impactando el agua alrededor de los barcos y creando pequeñas explosiones y salpicaduras. Aunque la batalla aún no ha alcanzado su clímax, la superioridad tecnológica y numérica de los invasores es evidente e insuperable. El cielo está cargado de nubes oscuras y dramáticas, iluminadas intermitentemente por los destellos de la tecnología alienígena, lo que acentúa la sensación de un destino inevitable.\n" + "\n" + "La imagen evoca una profunda sensación de impotencia ante un poder cósmico. La flota medieval, con toda su valentía y esfuerzo, no tiene ninguna posibilidad frente a esta invasión interestelar, marcando el final de una era y el inicio de una dominación alienígena. Es un recordatorio visual de la fragilidad de la civilización humana frente a lo desconocido."),
            Galeria(R.drawable.ciudadela,"Archipiélago de Luz: Ciudad del Horizonte Sumergido","La imagen retrata una metrópolis acuática de ensueño, compuesta por múltiples islas circulares que flotan sobre un mar vibrante y dinámico. Cada isla está conectada por puentes elevados que parecen fluir como arterias entre los núcleos urbanos, formando una red orgánica que sugiere tanto planificación avanzada como armonía con el entorno natural. Las estructuras que coronan cada isla son imponentes y estilizadas, con torres que se elevan hacia el cielo en formas curvas y ornamentadas, iluminadas por luces que emanan un resplandor cálido y futurista. Estas edificaciones evocan una mezcla de arquitectura gótica, tecnología avanzada y diseño biofílico, como si la civilización que las habita hubiera fusionado arte, ciencia y naturaleza en una sola expresión urbana.\n" + "\n" + "El agua que rodea el archipiélago no es estática; muestra corrientes visibles, reflejos intensos y pequeñas embarcaciones que se deslizan entre las islas, añadiendo movimiento y vida al paisaje. La superficie líquida actúa como espejo y como vía, integrando la ciudad con su base acuática en una simbiosis perfecta. El cielo, por su parte, está cubierto por nubes dramáticas que se tiñen de azul profundo, creando un contraste atmosférico que intensifica la sensación de misterio y grandeza. La luz parece filtrarse desde múltiples fuentes, tanto naturales como artificiales, bañando la escena en tonos que oscilan entre lo celestial y lo tecnológico.\n" + "\n" + "En conjunto, la imagen transmite la visión de una civilización avanzada que ha aprendido a convivir con el agua como elemento central de su existencia. No es solo una ciudad flotante, sino un ecosistema urbano que respira, brilla y se mueve con elegancia. La composición visual sugiere una utopía acuática donde la innovación, la estética y la sostenibilidad convergen en una obra maestra arquitectónica y ambiental."),
        )
    }

    // Estructura base de la pantalla con barra superior e inferior
    Scaffold(
        topBar = {
            // Barra superior con título
            TopAppBar(
                title = { Text("Galería de imágenes") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        },
        bottomBar = {
            // Barra inferior vacía, reservada para futuros elementos
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ) {}
        },
        // Color de fondo general de la pantalla
        containerColor = MaterialTheme.colorScheme.background
    ) {
        // Contenedor principal de la galería
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Lista horizontal de imágenes desplazables
            LazyRow(
                contentPadding = PaddingValues(start = 24.dp, end = 40.dp),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {

                // Cada imagen se define como un 'item' dentro del LazyRow
                // Al hacer clic en una imagen, se navega a la pantalla de detalle
                item {
                    Image(
                        painter = painterResource(id = R.drawable.castilllo),
                        contentDescription = "Primera imagen",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .clip(CircleShape) // Imagen circular
                            .size(350.dp)
                            .clickable {
                                val item = galeriaImagenes[0]
                                // Navega hacia la pantalla de detalle pasando los argumentos
                                navController.navigate(
                                    "detalle/${item.imagen}/${item.titulo}/${item.descripcion}"
                                )
                            },
                    )
                }

                item {
                    Image(
                        painter = painterResource(id = R.drawable.avion),
                        contentDescription = "Segunda imagen",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(350.dp)
                            .clickable {
                                val item = galeriaImagenes[1]
                                navController.navigate(
                                    "detalle/${item.imagen}/${item.titulo}/${item.descripcion}"
                                )
                            },
                    )
                }

                item {
                    Image(
                        painter = painterResource(id = R.drawable.barco),
                        contentDescription = "Tercera imagen",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(350.dp)
                            .clickable {
                                val item = galeriaImagenes[2]
                                navController.navigate(
                                    "detalle/${item.imagen}/${item.titulo}/${item.descripcion}"
                                )
                            },
                    )
                }

                item {
                    Image(
                        painter = painterResource(id = R.drawable.ciudadela),
                        contentDescription = "Cuarta imagen",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(350.dp)
                            .clickable {
                                val item = galeriaImagenes[3]
                                navController.navigate(
                                    "detalle/${item.imagen}/${item.titulo}/${item.descripcion}"
                                )
                            },
                    )
                }

                // Imagen repetida opcionalmente para extender el scroll
                item {
                    Image(
                        painter = painterResource(id = R.drawable.castilllo),
                        contentDescription = "Quinta imagen",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(350.dp)
                            .clickable {
                                val item = galeriaImagenes[0]
                                navController.navigate(
                                    "detalle/${item.imagen}/${item.titulo}/${item.descripcion}"
                                )
                            },
                    )
                }
            }
        }
    }
}
