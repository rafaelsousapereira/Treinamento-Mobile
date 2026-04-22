package com.treinamentomobile.exemplolivedata.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.treinamentomobile.exemplolivedata.model.IncrementModel
import com.treinamentomobile.exemplolivedata.viewmodel.IncrementViewModel

@Composable
fun IncrementScreen(viewModel: IncrementViewModel) {
    // Vincular com a camada ViewModel
    val objViewModel by viewModel.obj.observeAsState(IncrementModel())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Exibir o contador
        Text("Contador: ${objViewModel.counter}")

        // Botão
        Button(onClick = { viewModel.incrementCounter() }) {
            Text("Incrementar +1")
        }
    }

}