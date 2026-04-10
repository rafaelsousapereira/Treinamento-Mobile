package com.treinamentomobile.navegacaomenubotton

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.treinamentomobile.navegacaomenubotton.ui.theme.NavegacaoMenuBottonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoMenuBottonTheme {
                GerenciadorNavegacao()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GerenciadorNavegacao() {

    // Objeto NavController para gerenciar rotas
    val navController = rememberNavController()

    // TopBar, BotttomBar e conteúdos (páginas)
    Scaffold(
        // BottomBar - Menu inferior
        bottomBar = {

            // NavigationBar - Componente para englobar os links
            NavigationBar {
                // Link - Início
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("inicio") },
                    icon = { Icon( Icons.Default.Home, contentDescription = null ) }
                )

                // Link - Perfil
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("perfil") },
                    icon = { Icon( Icons.Default.Person, contentDescription = null ) }
                )

                // Link - Configurações
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("configuracoes") },
                    icon = { Icon( Icons.Default.Settings, contentDescription = null ) }
                )

            }
        }
    ) {
        NavHost(navController = navController, startDestination = "inicio") {
            composable("inicio") { Inicio() }
            composable("perfil") { Perfil() }
            composable("configuracoes") { Configuracoes() }
        }
    }
}

@Composable
fun Inicio() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Início", fontSize = 30.sp)
    }
}

@Composable
fun Perfil() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Perfil", fontSize = 30.sp)
    }
}

@Composable
fun Configuracoes() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Configurações", fontSize = 30.sp)
    }
}









