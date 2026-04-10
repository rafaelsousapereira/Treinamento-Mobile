package com.treinamentomobile.gestorfinanceiro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.treinamentomobile.gestorfinanceiro.ui.theme.GestorFinanceiroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GestorFinanceiroTheme {
                GerenciadorTelas()
            }
        }
    }
}

@Composable
fun MinhaConta() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Início | Minha Conta",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        ElevatedCard(
            colors = CardDefaults
                .cardColors(
                    containerColor = Color(0xFFEFE9E3)
                ),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Text(
                text = "Saldo Atual R$ 5.000,00",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(12.dp),
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row() {
            Text(text = "Ganhos ->")
            Text(text = "Gastos <-")
            Text(text = "Sonhos & Desejos (^^")

            Spacer(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(66.dp))

        Text(text = "---- Resumo do Mês ----")
        
        Spacer(modifier = Modifier.height(66.dp))


        Column() {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)) {
                Text(text = "Ganhos")
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)) {
                Text(text = "Gastos")
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)) {
                Text(text = "Sonhos")
            }
        }
    }
}

@Composable
fun Ganhos() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Meus Ganhos",
            fontSize = 30.sp
        )
    }
}

@Composable
fun Gastos() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Meus Gastos",
            fontSize = 30.sp
        )
    }
}

@Composable
fun SonhosDesejos() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sonhos & Desejos",
            fontSize = 30.sp
        )
    }
}

@Composable
fun GerenciadorTelas() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    // Garante que o fundo da tela siga o tema, se branco no light, escuro no dark.
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    // Início
                    NavigationBarItem(
                        selected = currentDestination == "minhaConta",
                        onClick = {
                            navController.navigate("minhaConta") {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Icons.Default.Home, contentDescription = "Início") },
                        label = { Text("Início") }
                    )

                    // Ganhos
                    NavigationBarItem(
                        selected = currentDestination == "ganhos",
                        onClick = {
                            navController.navigate("ganhos") {
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ganho),
                                contentDescription = "Ganhos",
                                modifier = Modifier.size(25.dp)
                            )
                        },
                        label = { Text("Ganhos") }
                    )

                    // Gastos
                    NavigationBarItem(
                        selected = currentDestination == "gastos",
                        onClick = {
                            navController.navigate("gastos") {
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.gasta),
                                contentDescription = "Gastos",
                                modifier = Modifier.size(25.dp)
                            )
                        },
                        label = { Text("Gastos") }
                    )

                    // Expectativa
                    NavigationBarItem(
                        selected = currentDestination == "expectativa",
                        onClick = {
                            navController.navigate("expectativa") {
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.expectativa),
                                contentDescription = "Sonhos",
                                modifier = Modifier.size(25.dp)
                            )
                        },
                        label = { Text("Sonhos") }
                    )
                }
            }
        ) { innerPadding ->
            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                startDestination = "minhaConta"
            ) {
                composable("minhaConta") { MinhaConta() }
                composable("ganhos") { Ganhos() }
                composable("gastos") { Gastos() }
                composable("expectativa") { SonhosDesejos() }
            }
        }
    }
}
