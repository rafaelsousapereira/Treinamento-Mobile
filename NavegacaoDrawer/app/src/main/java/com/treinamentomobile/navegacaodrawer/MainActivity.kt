package com.treinamentomobile.navegacaodrawer

import android.R.attr.type
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.treinamentomobile.navegacaodrawer.ui.theme.NavegacaoDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoDrawerTheme {
                GerenciadorAtividadeNavegacao1()
            }
        }
    }
}

// Atividades

// Tela principal
@Composable
fun TelaPrincipal(
    exibirProximaTela: (Int) -> Unit
) {
    val navController = rememberNavController()
    val destinos = listOf(
        """
    🧭 Fernando de Noronha
    País: Brasil
    Cidade/Região: Fernando de Noronha (PE)
    """.trimIndent(),

        """
    🧭 Gramado
    País: Brasil
    Cidade/Região: Gramado (RS)
    """.trimIndent(),

        """
    🧭 Lençóis Maranhenses
    País: Brasil
    Cidade/Região: Barreirinhas (MA)
    """.trimIndent(),

        """
    🧭 Rio de Janeiro
    País: Brasil
    Cidade/Região: Rio de Janeiro (RJ)
    """.trimIndent(),

        """
    🧭 Foz do Iguaçu
    País: Brasil
    Cidade/Região: Foz do Iguaçu (PR)
    """.trimIndent(),

        """
    🧭 Machu Picchu
    País: Peru
    Cidade/Região: Cusco
    """.trimIndent(),

        """
    🧭 Salar de Uyuni
    País: Bolívia
    Cidade/Região: Uyuni
    """.trimIndent(),

        """
    🧭 Torres del Paine
    País: Chile
    Cidade/Região: Patagônia
    """.trimIndent(),

        """
    🧭 Buenos Aires
    País: Argentina
    Cidade/Região: Buenos Aires
    """.trimIndent(),

        """
    🧭 Cancun
    País: México
    Cidade/Região: Cancun
    """.trimIndent(),

        """
    🧭 Nova York
    País: EUA
    Cidade/Região: Nova York
    """.trimIndent(),

        """
    🧭 Vancouver
    País: Canadá
    Cidade/Região: Vancouver
    """.trimIndent(),

        """
    🧭 Paris
    País: França
    Cidade/Região: Paris
    """.trimIndent(),

        """
    🧭 Roma
    País: Itália
    Cidade/Região: Roma
    """.trimIndent(),

        """
    🧭 Barcelona
    País: Espanha
    Cidade/Região: Barcelona
    """.trimIndent(),

        """
    🧭 Londres
    País: Reino Unido
    Cidade/Região: Londres
    """.trimIndent(),

        """
    🧭 Amsterdã
    País: Países Baixos
    Cidade/Região: Amsterdã
    """.trimIndent(),

        """
    🧭 Tóquio
    País: Japão
    Cidade/Região: Tóquio
    """.trimIndent(),

        """
    🧭 Bangkok
    País: Tailândia
    Cidade/Região: Bangkok
    """.trimIndent(),

        """
    🧭 Sydney
    País: Austrália
    Cidade/Região: Sydney
    """.trimIndent()
    )


    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(destinos) { index, item ->

            Card(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .height(150.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Text(item)

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 15.dp, horizontal = 5.dp),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Button(

                            onClick = {
                                exibirProximaTela(index)
                            }
                        ) {
                            Text("Mais detalhes")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProximaTela(
    indiceDestino: Int,
    voltarTelaPrincipal: () -> Unit
) {
    val destinos = listOf(
        """
    🧭 Fernando de Noronha
    País: Brasil
    Cidade/Região: Fernando de Noronha (PE)
    Continente: América do Sul
    Clima: Tropical
    Melhor época: Ago–Nov
    Moeda: BRL
    Idioma: Português
    Nível de custo: Alto
    Tempo mínimo: 4 dias
    Atração principal: Praias e mergulho
    Destaque: Águas cristalinas e vida marinha intensa
    """.trimIndent(),

        """
    🧭 Gramado
    País: Brasil
    Cidade/Região: Gramado (RS)
    Continente: América do Sul
    Clima: Temperado
    Melhor época: Jun–Ago
    Moeda: BRL
    Idioma: Português
    Nível de custo: Alto
    Tempo mínimo: 3 dias
    Atração principal: Serra e gastronomia
    Destaque: Cidade charmosa com festivais e chocolate artesanal
    """.trimIndent(),

        """
    🧭 Lençóis Maranhenses
    País: Brasil
    Cidade/Região: Barreirinhas (MA)
    Continente: América do Sul
    Clima: Tropical
    Melhor época: Jun–Set
    Moeda: BRL
    Idioma: Português
    Nível de custo: Médio
    Tempo mínimo: 3 dias
    Atração principal: Lagoas entre dunas
    Destaque: Dunas brancas e lagoas sazonais incríveis
    """.trimIndent(),

        """
    🧭 Rio de Janeiro
    País: Brasil
    Cidade/Região: Rio de Janeiro (RJ)
    Continente: América do Sul
    Clima: Tropical
    Melhor época: Mai–Out
    Moeda: BRL
    Idioma: Português
    Nível de custo: Médio
    Tempo mínimo: 4 dias
    Atração principal: Cristo Redentor
    Destaque: Praias, trilhas e cultura urbana
    """.trimIndent(),

        """
    🧭 Foz do Iguaçu
    País: Brasil
    Cidade/Região: Foz do Iguaçu (PR)
    Continente: América do Sul
    Clima: Subtropical
    Melhor época: Mar–Mai
    Moeda: BRL
    Idioma: Português
    Nível de custo: Médio
    Tempo mínimo: 3 dias
    Atração principal: Cataratas do Iguaçu
    Destaque: Quedas d’água gigantes e parques naturais
    """.trimIndent(),

        """
    🧭 Machu Picchu
    País: Peru
    Cidade/Região: Cusco
    Continente: América do Sul
    Clima: Frio de altitude
    Melhor época: Mai–Set
    Moeda: PEN
    Idioma: Espanhol
    Nível de custo: Médio
    Tempo mínimo: 4 dias
    Atração principal: Ruínas incas
    Destaque: Trilha e história em paisagens montanhosas
    """.trimIndent(),

        """
    🧭 Salar de Uyuni
    País: Bolívia
    Cidade/Região: Uyuni
    Continente: América do Sul
    Clima: Frio e seco
    Melhor época: Mai–Nov
    Moeda: BOB
    Idioma: Espanhol
    Nível de custo: Médio
    Tempo mínimo: 3 dias
    Atração principal: Deserto de sal
    Destaque: Efeito espelho na época de chuvas
    """.trimIndent(),

        """
    🧭 Torres del Paine
    País: Chile
    Cidade/Região: Patagônia
    Continente: América do Sul
    Clima: Frio e ventoso
    Melhor época: Nov–Mar
    Moeda: CLP
    Idioma: Espanhol
    Nível de custo: Alto
    Tempo mínimo: 5 dias
    Atração principal: Trekking e geleiras
    Destaque: Montanhas e lagos glaciais espetaculares
    """.trimIndent(),

        """
    🧭 Buenos Aires
    País: Argentina
    Cidade/Região: Buenos Aires
    Continente: América do Sul
    Clima: Temperado
    Melhor época: Mar–Mai
    Moeda: ARS
    Idioma: Espanhol
    Nível de custo: Médio
    Tempo mínimo: 4 dias
    Atração principal: Cultura e tango
    Destaque: Gastronomia, arquitetura e bairros históricos
    """.trimIndent(),

        """
    🧭 Cancun
    País: México
    Cidade/Região: Cancun
    Continente: América do Norte
    Clima: Tropical
    Melhor época: Dez–Abr
    Moeda: MXN
    Idioma: Espanhol
    Nível de custo: Médio
    Tempo mínimo: 5 dias
    Atração principal: Praias do Caribe
    Destaque: Resorts e passeios a cenotes
    """.trimIndent(),

        """
    🧭 Nova York
    País: EUA
    Cidade/Região: Nova York
    Continente: América do Norte
    Clima: Temperado
    Melhor época: Abr–Jun
    Moeda: USD
    Idioma: Inglês
    Nível de custo: Alto
    Tempo mínimo: 5 dias
    Atração principal: Times Square
    Destaque: Museus, shows e parques urbanos
    """.trimIndent(),

        """
    🧭 Vancouver
    País: Canadá
    Cidade/Região: Vancouver
    Continente: América do Norte
    Clima: Temperado
    Melhor época: Jun–Set
    Moeda: CAD
    Idioma: Inglês
    Nível de custo: Alto
    Tempo mínimo: 4 dias
    Atração principal: Natureza urbana
    Destaque: Montanhas, mar e trilhas perto do centro
    """.trimIndent(),

        """
    🧭 Paris
    País: França
    Cidade/Região: Paris
    Continente: Europa
    Clima: Temperado
    Melhor época: Abr–Jun
    Moeda: EUR
    Idioma: Francês
    Nível de custo: Alto
    Tempo mínimo: 4 dias
    Atração principal: Torre Eiffel
    Destaque: Arte, culinária e passeios românticos
    """.trimIndent(),

        """
    🧭 Roma
    País: Itália
    Cidade/Região: Roma
    Continente: Europa
    Clima: Mediterrâneo
    Melhor época: Abr–Jun
    Moeda: EUR
    Idioma: Italiano
    Nível de custo: Médio
    Tempo mínimo: 4 dias
    Atração principal: Coliseu
    Destaque: História antiga e culinária clássica
    """.trimIndent(),

        """
    🧭 Barcelona
    País: Espanha
    Cidade/Região: Barcelona
    Continente: Europa
    Clima: Mediterrâneo
    Melhor época: Mai–Set
    Moeda: EUR
    Idioma: Espanhol
    Nível de custo: Médio
    Tempo mínimo: 4 dias
    Atração principal: Sagrada Família
    Destaque: Praias e arquitetura de Gaudí
    """.trimIndent(),

        """
    🧭 Londres
    País: Reino Unido
    Cidade/Região: Londres
    Continente: Europa
    Clima: Oceânico
    Melhor época: Mai–Set
    Moeda: GBP
    Idioma: Inglês
    Nível de custo: Alto
    Tempo mínimo: 5 dias
    Atração principal: Big Ben e museus
    Destaque: História, bairros famosos e cultura pop
    """.trimIndent(),

        """
    🧭 Amsterdã
    País: Países Baixos
    Cidade/Região: Amsterdã
    Continente: Europa
    Clima: Temperado
    Melhor época: Abr–Out
    Moeda: EUR
    Idioma: Holandês
    Nível de custo: Alto
    Tempo mínimo: 3 dias
    Atração principal: Canais e museus
    Destaque: Cidade compacta e fácil de explorar a pé/bicicleta
    """.trimIndent(),

        """
    🧭 Tóquio
    País: Japão
    Cidade/Região: Tóquio
    Continente: Ásia
    Clima: Temperado
    Melhor época: Mar–Mai
    Moeda: JPY
    Idioma: Japonês
    Nível de custo: Alto
    Tempo mínimo: 5 dias
    Atração principal: Shibuya e tecnologia
    Destaque: Tradição e futurismo com gastronomia incrível
    """.trimIndent(),

        """
    🧭 Bangkok
    País: Tailândia
    Cidade/Região: Bangkok
    Continente: Ásia
    Clima: Tropical
    Melhor época: Nov–Fev
    Moeda: THB
    Idioma: Tailandês
    Nível de custo: Baixo
    Tempo mínimo: 4 dias
    Atração principal: Templos e mercados
    Destaque: Comida de rua e cultura vibrante
    """.trimIndent(),

        """
    🧭 Sydney
    País: Austrália
    Cidade/Região: Sydney
    Continente: Oceania
    Clima: Temperado
    Melhor época: Set–Nov
    Moeda: AUD
    Idioma: Inglês
    Nível de custo: Alto
    Tempo mínimo: 5 dias
    Atração principal: Opera House
    Destaque: Praias, trilhas costeiras e paisagens urbanas
    """.trimIndent()
    )
    val destinoSelecionado = destinos[indiceDestino]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "CARACTERÍSTICAS:", fontSize = 22.sp)

                Spacer(modifier = Modifier.height(12.dp))

                Text(text = destinoSelecionado, fontSize = 14.sp)

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = voltarTelaPrincipal,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(vertical = 15.dp, horizontal = 5.dp)
                ) {
                    Text("Voltar")
                }
            }
        }
    }
}

@Composable
fun GerenciadorAtividadeNavegacao1() {
    val navController = rememberNavController()

    Column() {
        // Exibição das telas

        NavHost(navController, startDestination = "lista") {

            composable("lista") {
                TelaPrincipal { index ->
                    navController.navigate("detalhe/$index")
                }
            }

            composable(
                route = "detalhe/{index}",
                arguments = listOf(navArgument("index") { type = NavType.IntType })
            ) { backStackEntry ->
                val index = backStackEntry.arguments?.getInt("index") ?: 0

                ProximaTela(
                    indiceDestino = index,
                    voltarTelaPrincipal = { navController.popBackStack() }
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Gerenciador() {

    // NavController
    val navController = rememberNavController()

    // Objeto para gerenciar abertura e fechamento do menu
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    // Responsável por alterar o valor do drawerState
    val scope = rememberCoroutineScope()

    // Englobar menu e conteúdos (telas)
    ModalNavigationDrawer(
        // Verificar se o menu inicialmente ficará aberto ou fechado
        drawerState = drawerState,

        // Estrutura/conteúdo do menu horizontal
        drawerContent = {
            // Menu horizontal
            ModalDrawerSheet {
                // Título do menu (opcional)
                Text(text = "MENU", modifier = Modifier.padding(12.dp))

                // Linha - Divisória (opcional)
                HorizontalDivider()

                // Link - Início
                NavigationDrawerItem(
                    label = { Text("Início") },
                    selected = false,
                    onClick = {
                        // Selecionar a tela que será exibida
                        navController.navigate("inicio")

                        // Fechar menu
                        scope.launch { drawerState.close() }
                    },
                    icon = {
                        Icon(Icons.Default.Home, contentDescription = null)
                    }
                )

                // LInk - Perfil
                NavigationDrawerItem(
                    label = { Text("Perfil") },
                    selected = false,
                    onClick = {
                        // Selecionar a tela que será exibida
                        navController.navigate("perfil")

                        // Fechar menu
                        scope.launch { drawerState.close() }
                    },
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = null)
                    }
                )

                // Link - Configurações
                NavigationDrawerItem(
                    label = { Text("Confiugurações") },
                    selected = false,
                    onClick = {
                        // Selecionar a tela que será exibida
                        navController.navigate("configuracoes")

                        // Fechar menu
                        scope.launch { drawerState.close() }
                    },
                    icon = {
                        Icon(Icons.Default.Settings, contentDescription = null)
                    }
                )
            }
        }
    ) {
        // Scaffold
        Scaffold(
            //Barra superior
            topBar = {
                // Estrutura da barra superior
                TopAppBar(
                    title = { Text("Título") },
                    navigationIcon = {
                        IconButton(
                            onClick = { scope.launch { drawerState.open() } }
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = null)
                        }
                    }
                )
            }
        ) {
            //Exibiçao das telas
            NavHost(
                navController = navController,
                startDestination = "inicio"
            ) {
                composable("inicio") { Inicio() }
                composable("perfil") { Perfil() }
                composable("configuracoes") { Configuracoes() }

            }
        }
    }

}

@Composable
fun Inicio() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.Home,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Início",
            fontSize = 25.sp
        )
    }
}

@Composable
fun Perfil() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.Person,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Perfil",
            fontSize = 35.sp
        )
    }
}

@Composable
fun Configuracoes() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.Settings,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Configurações",
            fontSize = 35.sp
        )
    }
}
