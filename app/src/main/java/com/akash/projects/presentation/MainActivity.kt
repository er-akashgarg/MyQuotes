package com.akash.projects.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akash.projects.navigation.AppNavController
import com.akash.projects.presentation.screens.homescreen.HomeScreen
import com.akash.projects.ui.theme.MyQuotesComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyQuotesComposeAppTheme {
                AppNavController()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyQuotesComposeAppTheme {
        HomeScreen{}
    }
}
