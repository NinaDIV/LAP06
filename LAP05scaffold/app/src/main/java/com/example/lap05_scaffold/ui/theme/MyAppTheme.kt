import androidx.compose.material3.* // Componentes de Material Design 3
import androidx.compose.runtime.Composable // Para funciones composables
import androidx.compose.ui.Modifier // Para modificar componentes
import androidx.compose.ui.graphics.Color // Para colores
import androidx.compose.ui.text.font.FontWeight // Para grosor de fuente
import androidx.compose.ui.unit.dp // Para dimensiones en dp
import androidx.compose.ui.unit.sp // Para tamaño de fuente en sp
import androidx.compose.ui.tooling.preview.Preview // Para vista previa
import androidx.compose.foundation.layout.* // Para layout
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment // Para alineación
import androidx.compose.ui.text.TextStyle

// Tema de la aplicación
@Composable
fun MyAppTheme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = Color(0xFF6200EE), // Color principal
        secondary = Color(0xFF03DAC5), // Color secundario
        background = Color(0xFFFFFFFF), // Color de fondo
        surface = Color(0xFFF0F0F0) // Color de superficie
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MyTypography, // Tipografía definida más abajo
        shapes = Shapes(), // Formas definidas más abajo
        content = content // Contenido que usará este tema
    )
}

// Tipografía de la aplicación
val MyTypography = Typography(
    headlineLarge = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold), // Título
    bodyLarge = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal) // Texto normal
)

// Formas de los componentes
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp), // Esquinas redondeadas pequeñas
    medium = RoundedCornerShape(8.dp), // Esquinas redondeadas medianas
    large = RoundedCornerShape(16.dp) // Esquinas redondeadas grandes
)

// Función principal de la app
@Composable
fun MyApp() {
    MyAppTheme {
        Surface { // Superficie para contener el contenido
            Column(
                modifier = Modifier.padding(16.dp), // Espaciado
                horizontalAlignment = Alignment.CenterHorizontally, // Alineación
                verticalArrangement = Arrangement.Center // Centrando verticalmente
            ) {
                Text("Hello, Material Theme!", style = MaterialTheme.typography.headlineLarge) // Mensaje
                Button(onClick = { /* Acción */ }) { // Botón
                    Text("Click Me") // Texto del botón
                }
            }
        }
    }
}

// Vista previa de la aplicación
@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    MyApp() // Muestra la app en la vista previa
}
