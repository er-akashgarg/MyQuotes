package com.akash.projects.domain.repository

import com.akash.projects.domain.models.AllQuotesDC
import com.akash.projects.domain.models.QuoteDC
import retrofit2.Response

interface QuoteRepository {

    suspend fun getAllQuotes(): Response<AllQuotesDC>

    suspend fun getRandomQuote(): Response<QuoteDC>

    suspend fun getSingleQuote(id: String): Response<QuoteDC>
}