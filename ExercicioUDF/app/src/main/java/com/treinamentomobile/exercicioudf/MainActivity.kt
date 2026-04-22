package com.treinamentomobile.exercicioudf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.treinamentomobile.exercicioudf.ui.screen.GymStudentScreen
import com.treinamentomobile.exercicioudf.ui.theme.ExercicioUDFTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercicioUDFTheme {
                GymStudentScreen()
            }
        }
    }
}
