package com.akash.projects.presentation.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.akash.projects.domain.models.HomeQuoteDC
import com.akash.projects.network.NetworkUIState
import com.akash.projects.presentation.components.AppProgressBar
import com.akash.projects.presentation.components.ToolBarComponent
import com.akash.projects.presentation.screens.homescreen.components.HomeBody
import com.akash.projects.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onItemClick: (id:String) -> Unit
) {

    val state = homeViewModel.quotesData.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ToolBarComponent(showBackButton = false, title = "Home")
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {

            when (state) {
                is NetworkUIState.LOADING -> {
                    AppProgressBar()
                }

                is NetworkUIState.SUCCESS<HomeQuoteDC> -> {
                    HomeBody(state.data, onCardClick = onItemClick)
                }
                else -> Unit
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen {}
}