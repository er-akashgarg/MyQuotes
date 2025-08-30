package com.akash.projects.presentation.screens.homescreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akash.projects.domain.models.QuoteDC

@Composable
fun QuoteItem(
    quoteDC: QuoteDC,
    color: Color = Color.White,
    textColor: Color = Color.Black,
    modifier: Modifier = Modifier,
) {

    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = quoteDC.quote ?: "",
                color = textColor,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Justify,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier.padding(5.dp))
            Text(
                text = quoteDC.author ?: "",
                color = textColor,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                fontSize = 12.sp,
                fontWeight = FontWeight.W300
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuoteItemPreview() {
    QuoteItem(quoteDC = QuoteDC())
}


@Preview(showBackground = true)
@Composable
private fun RandomQuoteItemPreview() {
    QuoteItem(
        quoteDC = QuoteDC(),
        color = Color.Red, textColor = Color.White
    )
}
