package com.akash.projects.domain.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
class AllQuotesDC(
    @SerializedName("quotes")
    val quotes: List<QuoteDC>? = null
)

@Keep
 class QuoteDC(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("quote")
    val quote: String? = null,
    @SerializedName("author")
    val author: String? = null
)