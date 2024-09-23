package com.example.lap05_scaffold.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil de Usuario") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Rounded.KeyboardArrowLeft,contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Acción de búsqueda */ }) {
                        Icon(Icons.Rounded.Search, contentDescription = "Buscar")
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Foto del usuario (Placeholder)
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "User Icon",
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color.Gray, CircleShape)
                        .padding(8.dp),
                    tint = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Nombre de usuario
                Text(
                    text = "John Doe", // Nombre ficticio
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Correo electrónico u otra información
                Text(
                    text = "johndoe@example.com",
                    fontSize = 18.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Otras opciones o configuraciones de usuario
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(8.dp),
                    content = {
                        item { UserProfileOption("Configuración", Icons.Filled.Settings) }
                        item { UserProfileOption("Historial", Icons.Filled.DateRange) }
                        item { UserProfileOption("Ayuda", Icons.Filled.Info) }
                        item { UserProfileOption("Cerrar Sesión", Icons.Filled.ExitToApp) }
                    }
                )
            }
        }
    )
}

@Composable
fun UserProfileOption(optionText: String, icon: ImageVector) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable { /* Acción al hacer clic */ },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = Color(0xFF20232A)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = optionText, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    val navController = rememberNavController()
    UserProfileScreen(navController)
}
