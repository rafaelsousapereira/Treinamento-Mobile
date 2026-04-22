package com.treinamentomobile.exemplolivedata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.treinamentomobile.exemplolivedata.ui.screen.IncrementScreen
import com.treinamentomobile.exemplolivedata.ui.theme.ExemploLiveDataTheme
import com.treinamentomobile.exemplolivedata.viewmodel.IncrementViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IncrementScreen(viewModel = IncrementViewModel())
        }
    }
}
