package com.treinamentomobile.projetoudf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.treinamentomobile.projetoudf.ui.screen.PersonScreen
import com.treinamentomobile.projetoudf.ui.theme.ProjetoUDFTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetoUDFTheme {
                PersonScreen()
            }
        }
    }
}
