package com.akash.projects.presentation.screens.homescreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akash.projects.domain.models.HomeQuoteDC

@Composable
fun HomeBody(quoteDC: HomeQuoteDC, onCardClick: (id:String) -> Unit) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        quoteDC.randomQuote?.let {
            item {
                HeadingTitle(title = "Random Quote")
                RandomQuoteItem(randomQuoteDC = it)
            }
        }

        item {
            HeadingTitle(title = "Quotes")
        }

        items(quoteDC.allQuotes ?: emptyList()) {
            QuoteItem(
                quoteDC = it,
                modifier = Modifier.clickable { onCardClick(it.id.toString()) })
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
private fun HomeBodyPreview() {
    HomeBody(quoteDC = HomeQuoteDC()) {}
}