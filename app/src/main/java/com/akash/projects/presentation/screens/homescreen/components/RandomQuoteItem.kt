package com.akash.projects.presentation.screens.homescreen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.akash.projects.R
import com.akash.projects.domain.models.QuoteDC

@Composable
fun RandomQuoteItem(randomQuoteDC: QuoteDC) {
    QuoteItem(randomQuoteDC,
        color = colorResource(R.color.purple_500),
        textColor = Color.White)
}


@Preview
@Composable
private fun RandomQuoteItemPreview() {
    RandomQuoteItem(randomQuoteDC = QuoteDC())
}