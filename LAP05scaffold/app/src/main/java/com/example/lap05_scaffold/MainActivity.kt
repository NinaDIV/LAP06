package com.example.lap05_scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lap05_scaffold.ui.theme.LAP05scaffoldTheme
import com.example.lap05_scaffold.ui.theme.UserProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LAP05scaffoldTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppNavigation(navController)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { CustomScaffold(navController) }
        composable("profile") { UserProfileScreen(navController) }
    }
}

@Composable
fun CustomScaffold(navController: NavHostController) {
    var clickCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CustomTopBar() },
        bottomBar = { CustomBottomBar(navController) },
        floatingActionButton = {
            CustomFAB(onFabClick = { clickCount++ }) // Incrementa el contador
        },
        content = { padding ->
            CustomContent(padding, clickCount) // Pasa clickCount a CustomContent
        }
    )
}

@Composable
fun CustomTopBar() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(text = "July\n2022", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            DayButton(day = "S", number = "10", isSelected = false)
            DayButton(day = "M", number = "11", isSelected = false)
            DayButton(day = "T", number = "18", isSelected = true)
            DayButton(day = "W", number = "13", isSelected = false)
            DayButton(day = "T", number = "14", isSelected = false)
            DayButton(day = "F", number = "15", isSelected = false)
            DayButton(day = "S", number = "17", isSelected = false)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Today Report", color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp), fontSize = 24.sp)
    }
}

@Composable
fun DayButton(day: String, number: String, isSelected: Boolean) {
    FilledTonalButton(
        onClick = { /* Acción al hacer clic */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xFF20232A) else Color(0xFFB2FF59)
        ),
        shape = CircleShape,
        modifier = Modifier.size(48.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = day, color = if (isSelected) Color.White else Color.Black, fontSize = 12.sp)
            Text(text = number, color = if (isSelected) Color.White else Color.Black, fontSize = 12.sp)
        }
    }
}

@Composable
fun CustomContent(padding: PaddingValues, clickCount: Int) {
    Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            content = {
                item { HeartRateCard() }
                item { CyclingCard() }
                item { StepsCard() }
                item { SleepCard() }
                item { WaterCard() }
                item { WaterCard2(clickCount) } // Pasar el clickCount aquí
            }
        )
    }
}

@Composable
fun HeartRateCard() {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth().height(150.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Heart Rate", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "79 BPM", fontSize = 24.sp)
        }
    }
}

@Composable
fun CyclingCard() {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth().height(150.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Cycling", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Training Time: 80%", fontSize = 24.sp)
        }
    }
}

@Composable
fun StepsCard() {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth().height(150.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Steps", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "999/2000", fontSize = 24.sp)
        }
    }
}

@Composable
fun SleepCard() {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth().height(150.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Sleep", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "6/8 hours", fontSize = 24.sp)
        }
    }
}

@Composable
fun WaterCard() {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth().height(150.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Water", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "6/8 Cups", fontSize = 24.sp)
        }
    }
}

@Composable
fun WaterCard2(clickCount: Int) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth().height(150.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Water", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "$clickCount/8 Cups", fontSize = 24.sp)
        }
    }
}

@Composable
fun CustomBottomBar(navController: NavHostController) {
    BottomAppBar(
        modifier = Modifier.background(Color(0xFF181D45)) // Color de fondo oscuro para la barra
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(onClick = { /* Home action */ }) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "Home", tint = Color.Black)
            }

            IconButton(onClick = { /* Rocket action */ }) {
                Icon(imageVector = Icons.Filled.Send, contentDescription = "Rocket", tint = Color.Black)
            }

            FilledTonalButton(
                onClick = { /* Analytics action */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB2FF59)),
                shape = CircleShape,
                modifier = Modifier.height(48.dp).padding(horizontal = 10.dp)
            ) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Analytics", tint = Color.Black)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Analytics", color = Color.Black)
            }

            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "User", tint = Color.Black)
            }

            IconButton(onClick = { /* Menu action */ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu", tint = Color.Black)
            }
        }
    }
}

@Composable
fun CustomFAB(onFabClick: () -> Unit) {
    FloatingActionButton(onClick = { onFabClick() }) {
        Text(fontSize = 24.sp, text = "+") // Texto del botón
    }
}


@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    LAP05scaffoldTheme {
        val navController = rememberNavController()
        CustomScaffold(navController)
    }
}
