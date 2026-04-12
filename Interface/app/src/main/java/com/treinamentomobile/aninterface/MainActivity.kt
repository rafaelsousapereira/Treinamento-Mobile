package com.treinamentomobile.aninterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.treinamentomobile.aninterface.ui.theme.InterfaceTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterfaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Atividade5(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color.White)
                    )
                }
            }
        }
    }
}

// Atividades
@Composable
fun Atividade5(modifier: Modifier) {

    val lista = listOf<String>(
        "Nike"
    )

    // Estrutura


    Column() {
        Card(
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 10.dp
                )
                .height(220.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),

            ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tenis_vans),
                    contentDescription = "Imagem de tênis Vans",
                    modifier = Modifier
                        .fillMaxHeight()
                        .size(100.dp)
                )
                Text("Tênis Vans - Preto")
            }

        }
    }
}

@Composable
fun ExibirModal(exibirModal: Boolean, nome: String, media: Double) {
    var exibir by remember { mutableStateOf(false) }

    if (exibir) {
        AlertDialog(
            onDismissRequest = { exibir = false },
            title = {
                Text(
                    text = "$nome, obteve média: ${"%.2f".format(media)}",
                    modifier = Modifier
                        .padding(10.dp)
                )
            },
//                    text = { Text("Hello World!!!") },
            confirmButton = { Button(onClick = { exibir = false }) { Text("Ok") } },
            dismissButton = {
                Button(
                    onClick = { exibir = false }
                ) {
                    Text("Fechar")
                }
            }
        )
    }
}

@Composable
fun Atividade4(modifier: Modifier) {
    var nome by remember { mutableStateOf("") }
    var nota1 by remember { mutableStateOf("") }
    var nota2 by remember { mutableStateOf("") }
    var nota3 by remember { mutableStateOf("") }
    var media by remember { mutableStateOf(0.0) }
    var situacao by remember { mutableStateOf("") }
    var exibir by remember { mutableStateOf(false) }
    var habilitarBotao by remember { mutableStateOf(false) }

    var nomeValido = nome.length >= 2

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = nome,
            onValueChange = { nome = it },
            placeholder = { Text("Informe seu nome") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            modifier = Modifier.padding(10.dp),
            trailingIcon = {
                if (nomeValido) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Nome válido",
                        tint = Color.Green
                    )
                }
            }
        )
        TextField(
            value = nota1,
            onValueChange = { nota1 = it },
            placeholder = { Text("Informe a nota 1") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(10.dp),
            trailingIcon = {
                if (nota1.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Nome válido",
                        tint = Color.Green
                    )
                }
            }
        )
        TextField(
            value = nota2,
            onValueChange = { nota2 = it },
            placeholder = { Text("Informe a nota 2") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(10.dp),
            trailingIcon = {
                if (nota2.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Nome válido",
                        tint = Color.Green
                    )
                }
            }
        )
        TextField(
            value = nota3,
            onValueChange = { nota3 = it },
            placeholder = { Text("Informe a nota 3") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(10.dp),
            trailingIcon = {
                if (nota3.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Nome válido",
                        tint = Color.Green
                    )
                    habilitarBotao = true
                }
            }
        )
        Button(
            onClick = {
                media = (nota1.toDouble() + nota2.toDouble() + nota3.toDouble()) / 3

                if (media >= 7) {
                    situacao = "Aprovado!"
                    exibir = true
                } else {
                    situacao = "Reprovado!"
                    exibir = true
                }
            },
            //enabled = habilitarBotao // ver essa lógica com calma depois
        ) {
            Text("Calcular Média")
        }

        if (exibir) {
            AlertDialog(
                onDismissRequest = { exibir = false },
                title = {
                    Column(modifier = Modifier.padding(5.dp)) {
                        Row() {
                            Text(
                                text = "$nome, obteve média: ${"%.2f".format(media)}",
                                fontSize = 15.sp
                            )
                        }
                        Row() {
                            Text(
                                text = "Situação: $situacao",
                                fontSize = 15.sp
                            )
                        }
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            exibir = false
                        }
                    ) {
                        Text("Fechar")
                    }
                }
            )
        }
    }
}

// Componentes
@Composable
fun Componente12(modifier: Modifier) {
    var temaClaro by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(if (temaClaro) Color.White else Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = temaClaro,
            onCheckedChange = { temaClaro = it }
        )
    }
}


@Composable
fun Componente11(modifier: Modifier) {
    /**
     * LazyVerticalGrid -> Coluna
     * LazyHorizontalGrid -> Linha
     *
     * GridCells:
     * Adaptative -> Define um tamanho mínimo
     * Fixed -> Percentual a quantidade de colunas
     * FixedSize -> Define um tamanho único
     */

    // Lista com 30 números
    val numeros = List(30) { it }

    // Variável para armazenar o número selecionado
    var numeroSelecionado by remember { mutableStateOf("Nenhum número selecionado.") }


    // Estrutura
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                text = numeroSelecionado,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(vertical = 12.dp)
            )
        }

        items(numeros) { numero ->
            GerarCard(
                numero,
                funcaoSelecionarNumero = { valor ->
                    numeroSelecionado = "O número selecionado é: $valor"
                }
            )
        }
    }
}

@Composable
fun GerarCard(numero: Int, funcaoSelecionarNumero: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFc3ebed),
                            Color(0xFF2596be),
                            Color(0xFF154c79)
                        )
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = numero.toString(),
                fontSize = 25.sp,
                color = Color.White
            )
            Button(
                onClick = {
                    funcaoSelecionarNumero(numero)
                }
            ) {
                Text("Clique aqui")
            }
        }
    }

}

@Composable
fun Componente10(modifier: Modifier) {
    /**
     * BOX -> Caixa/Agrupador
     * Row -> Trabalhar com uma estrutura de linha
     * Column -> Trabalhar com uma estrutura de coluna
     *
     * LazyRow -> Trabalhar com uma estrutura de linha
     * LazyColumn -> Trabalhar com uma estrutura de coluna
     */
    val lista = List<String>(300) { "Item da lista ${it + 1}" }

    // Estrutura
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        // Laço de repetição
        items(lista) { item ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .height(80.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(item)
                }
            }
        }
    }
}

@Composable
fun Componente9(modifier: Modifier) {
    var exibir by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botão para exibir modal
        Button(onClick = { exibir = true }) {
            Text("Exibir modal")
        }

        // Componente Dialog (modal/janela)
        if (exibir) {
            AlertDialog(
                onDismissRequest = { exibir = false },
                title = { Text("Meu primeiro modal") },
                text = { Text("Hello World!!!") },
                confirmButton = { Button(onClick = { exibir = false }) { Text("Ok") } },
                dismissButton = {
                    Button(
                        onClick = { exibir = false }
                    ) {
                        Text("Fechar")
                    }
                }
            )
        }
    }
}


@Composable
fun Componente8(modifier: Modifier) {
    var email by remember { mutableStateOf("") }
    var emailValido = email.length >= 5 && email.contains("@")

    Column(
        modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            textStyle = TextStyle(color = Color.Black),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Ícone de e-mail"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//            isError = true, <- Deixa a borda vermelha em caso de falha
            trailingIcon = {
                if (email.isNotEmpty()) {
                    if (emailValido) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "E-mail válido",
                            tint = Color.Green
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "E-mail inválido",
                            tint = Color.Yellow
                        )
                    }
                }
            }
        )
    }
}


@Composable
fun Componente6(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            tint = Color.Blue,
            modifier = Modifier
                .size(60.dp)
        )

        // Espaçamento
        Spacer(modifier = Modifier.height(30.dp))

        Icon(
            imageVector = Icons.Default.Face,
//            painter = painterResource(
//                id = R.drawable.ic_android_black_24dp
//            ),
            contentDescription = "Ícone de diamante",
            tint = Color.Blue,
            modifier = Modifier.size(60.dp)
        )

        // Espaçamento
        Spacer(modifier = Modifier.height(30.dp))

        Icon(
            painter = painterResource(
                id = R.drawable.pc_active
            ),
            contentDescription = "Ícone de pc active",
            tint = Color.Blue,
            modifier = Modifier.size(60.dp)
        )
    }
}

@Composable
fun Componente7(modifier: Modifier) {

    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Card
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.Blue),
            modifier = Modifier.size(150.dp)
        ) { }

        // Espaçamento
        Spacer(modifier = modifier.height(30.dp))

        // Card com sombra
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .size(150.dp)
                .shadow(
                    elevation = 20.dp,
                    spotColor = Color.Red
                )
        ) { }

        // Espaçamento
        Spacer(modifier = modifier.height(30.dp))

        // Card com Borda
        OutlinedCard(
            border = BorderStroke(1.dp, Color.Black),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier.size(150.dp)
        ) { }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Annotation para informar que há uso de comandos consideradores experimentais
@Composable
fun Componente5(modifier: Modifier) {

    // Linguagens
    val linguagens = listOf("C#", "Java", "Kotlin", "Python")

    // Exibição do menu (dropdown)
    var menu by remember { mutableStateOf(false) }

    // Armazenar a linguagem selecionada
    var linguagemSelecionada by remember { mutableStateOf(linguagens[0]) }

    // Estrutura de coluna
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Título
        Text(text = "Escolha uma linguagem:")

        // ESSENCIAL: usar ExposedDropdownMenuBox
        ExposedDropdownMenuBox(
            expanded = menu,
            onExpandedChange = { menu = !menu }
        ) {

            // Campo (ancora do menu)
            TextField(
                value = linguagemSelecionada,
                onValueChange = {},
                readOnly = true,
                label = { Text("Linguagem") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(menu)
                },

                // MUITO IMPORTANTE: isso conecta o menu ao campo
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(
                        type = MenuAnchorType.PrimaryNotEditable,
                        enabled = true
                    )
            )

            // Menu dropdown
            ExposedDropdownMenu(
                expanded = menu,
                onDismissRequest = { menu = false }
            ) {
                linguagens.forEach { linguagem ->
                    DropdownMenuItem(
                        text = { Text(linguagem) },
                        onClick = {
                            linguagemSelecionada = linguagem
                            menu = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Componente4(modifier: Modifier) {
    // Linguegens de programação
    val linguangens = listOf<String>("C#", "Java", "Kotlin", "Python")

    // Obter a linguagem selecionada
    var linguagemSelecionada by remember { mutableStateOf(linguangens[0]) }

    // Estrutura
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Percorrer a lista de linguagens
        linguangens.forEach { linguagem ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = linguagem == linguagemSelecionada,
                        onClick = { linguagemSelecionada = linguagem }
                    )
            ) {
                RadioButton(
                    selected = linguagem == linguagemSelecionada,
                    onClick = null
                )
                Text(
                    text = linguagem
                )
            }
        }
        Text(
            text = "A linguagem selecionada é $linguagemSelecionada",
            fontSize = 25.sp
        )

    }
}

@Composable
fun Componente3(modifier: Modifier) {
    // Variavel de status do checkbox
    var status by remember { mutableStateOf(false) }

    // Estrutura
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Checkbox(
            checked = status,
            onCheckedChange = { valorAtual -> status = valorAtual }
        )
        Text(
            text = if (status) "Ativo" else "Inativo",
            fontSize = 30.sp,
            color = Color.Red
        )
    }
}

@Composable
fun Componente2(modifier: Modifier) {
    // Variável
    var numero by remember { mutableStateOf(0) }

    // Estrutura
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0058ab)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagem_icone),
            contentDescription = "Ícone de números"
        )
        Text(
            text = numero.toString(),
            color = Color.Black,
            fontSize = 50.sp,
            modifier = Modifier
                .padding(vertical = 15.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Botao("Incrementar") { numero++ }
            Botao("Decrementar") { numero-- }
        }
    }
}

@Composable
fun Componente1(modifier: Modifier) {
    // Variável contendo um texto
//    var texto = remember { mutableStateOf("") }
    var texto by remember { mutableStateOf("") }

    // Estrutura
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
//        Text(texto.value)
        Text(
            text = texto,
            textAlign = TextAlign.Center,
            fontSize = 35.sp,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        TextField(
            value = texto,
            onValueChange = { texto = it },
//            label = { Text("Digite algo...") },
            placeholder = { Text("Digite algo...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
}


/**
 * Layouts
 * Box -> Agrupador
 * Row -> Estrutura de linha
 * Column -> Estrutura de coluna
 */

@Composable
fun Estrutura3(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = modifier
                .background(Color.Red)
                .weight(1f)
                .fillMaxSize()
//                .size(50.dp)
        ) {
            Text("1")
        }
        Box(
            modifier = modifier
                .background(Color.Blue)
                .weight(1f)
                .fillMaxSize()
        ) {
            Text("2")
        }
        Box(
            modifier = modifier
                .background(Color.Green)
                .weight(1f)
                .fillMaxSize()
        ) {
            Text("3")
        }
        Box(
            modifier = modifier
                .background(Color.Magenta)
                .weight(1f)
                .fillMaxSize()
        ) {
            Text("4")
        }
    }
}

@Composable
fun Estrutura2(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = modifier
                .background(Color.Red)
                .weight(1f)
//                .size(50.dp)
        ) {
            Text("1")
        }
        Box(
            modifier = modifier
                .background(Color.Blue)
                .weight(1f)
        ) {
            Text("2")
        }
        Box(
            modifier = modifier
                .background(Color.Green)
                .weight(1f)
        ) {
            Text("3")
        }
        Box(
            modifier = modifier
                .background(Color.Magenta)
                .weight(1f)
        ) {
            Text("4")
        }
    }
}

@Composable
fun Estrutura1(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text("Meu primeiro layout...", fontSize = 30.sp)
    }
}

// Atividades - Componentes
@Composable
fun Atividade1(modifier: Modifier) {
    var nota1 by remember { mutableStateOf("") }
    var nota2 by remember { mutableStateOf("") }
    var nota3 by remember { mutableStateOf("") }
    var media by remember { mutableStateOf(0.0) }
    var situacao by remember { mutableStateOf("") }
    var imagem by remember { mutableStateOf(0) }

    // Estrutura
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nota1,
            onValueChange = { nota1 = it },
            placeholder = { Text("Informe a primeira nota") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = nota2,
            onValueChange = { nota2 = it },
            placeholder = { Text("Informe a primeira nota") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = nota3,
            onValueChange = { nota3 = it },
            placeholder = { Text("Informe a primeira nota") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(10.dp)
        )
        Button(
            onClick = {
                // Realizar média
                media = (nota1.toDouble() + nota2.toDouble() + nota3.toDouble()) / 3

                // Verificar a situação e a imagem
                if (media >= 7) {
                    situacao = "Aprovado(a)"
                    imagem = R.drawable.imagem_icone
                } else if (media >= 5) {
                    situacao = "Recuperação"
                    imagem = R.drawable.imagem_icone
                } else {
                    situacao = "Reprovado(a)"
                    imagem = R.drawable.imagem_icone
                }
            }
        ) {
            Text("Verificar situação")
        }

        // Caso seja realizada a média
        if (imagem != 0) {
            Text(
                text = "$situacao com média: ${"%.2f".format(media)}",
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Image(
                painter = painterResource(id = imagem),
                contentDescription = "Imagem da situação do aluno"
            )
        }
    }
}

@Composable
fun Atividade2(modifier: Modifier) {

    // Variáveis
    var valor by remember { mutableStateOf("") }
    val formasPagamento =
        listOf<String>("Cartão de Crédito", "Cartão de Débito", "PIX", "TED", "Dinheiro")
    var formaPagamentoSelecionada by remember { mutableStateOf(formasPagamento[0]) }
    var pagamentoTotal by remember { mutableStateOf("") }

    // Estrutura
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = valor,
            onValueChange = { valor = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Column() {
            formasPagamento.forEach { forma ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = forma == formaPagamentoSelecionada,
                            onClick = { formaPagamentoSelecionada = forma }
                        )) {
                    RadioButton(
                        selected = forma == formaPagamentoSelecionada,
                        onClick = null
                    )
                    Text(forma)
                }
            }
            Button(
                onClick = {

                    if (formaPagamentoSelecionada == "Cartão de Crédito" || formaPagamentoSelecionada == "Cartão de Débito")
                        pagamentoTotal = "Não haverá desconto! Total a pagar R$ $valor"
                    else {
                        if (valor.toDouble() > 1000) {
                            pagamentoTotal =
                                "Haverá desconto! Total a pagar R$ ${valor.toDouble() * 0.9}"
                        } else {
                            pagamentoTotal = "Não haverá desconto! Total a pagar R$ $valor"
                        }
                    }
                },
                modifier = Modifier
                    .padding(vertical = 10.dp)
            ) {
                Text("Calcular")
            }
            Text(pagamentoTotal)
        }
    }
}

@Composable
fun Atividade3(modifier: Modifier) {

    // Variáveis
    val numeroAleatorio = Random.nextInt(1, 101)
    var palpite by remember { mutableStateOf("") }
    var retorno by remember { mutableStateOf("") }
    var tentativas by remember { mutableStateOf(0) }

    // Estrutura
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        TextField(
            value = palpite,
            onValueChange = { palpite = it }
        )
        Button(
            onClick = {
                // Contabilizar tentiva
                tentativas++

                // Diferença entre o palpite e o número gerado
                val diferenca = kotlin.math.abs(palpite.toInt() - numeroAleatorio)

                // Retorno
                if (palpite.toInt() == numeroAleatorio) {
                    retorno = "Acertou!!! Você precisou de $tentativas tentativas"
                } else {

                    if (diferenca <= 5)
                        retorno = "Muito perto!"
                    else if (diferenca <= 10)
                        retorno = "Perto!"
                    else if (diferenca <= 15)
                        retorno = "Longe!"
                    else
                        retorno = "Muito longe!"
                }
            }
        ) {
            Text("Vamos lá!")
        }
        Text(retorno)
    }
}