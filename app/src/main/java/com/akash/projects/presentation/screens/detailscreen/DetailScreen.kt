package com.akash.projects.presentation.screens.detailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.akash.projects.R
import com.akash.projects.domain.models.QuoteDC
import com.akash.projects.network.NetworkUIState
import com.akash.projects.presentation.components.AppProgressBar
import com.akash.projects.presentation.components.ToolBarComponent
import com.akash.projects.presentation.screens.detailscreen.components.DetailQuote
import com.akash.projects.presentation.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel = hiltViewModel(), onBackPress: () -> Unit
) {
    val state = detailViewModel.singleQuoteData.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = Modifier.fillMaxSize(), topBar = {
            ToolBarComponent(
                showBackButton = true, title = "Detail Screen", onBackPress = onBackPress
            )
        }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(colorResource(R.color.white)),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is NetworkUIState.LOADING -> {
                    AppProgressBar()
                }

                is NetworkUIState.SUCCESS -> {
                    DetailQuote(state.data ?: QuoteDC())
                }

                else -> Unit
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen {}
}