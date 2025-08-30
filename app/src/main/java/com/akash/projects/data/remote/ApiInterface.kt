package com.akash.projects.data.remote

import com.akash.projects.domain.models.AllQuotesDC
import com.akash.projects.domain.models.QuoteDC
import com.akash.projects.network.ALL_QUOTES
import com.akash.projects.network.GET_SINGLE_QUOTE
import com.akash.projects.network.RANDOM_QUOTE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET(ALL_QUOTES)
    suspend fun getAllQuotes(): Response<AllQuotesDC>

    @GET(RANDOM_QUOTE)
    suspend fun getRandomQuotes(): Response<QuoteDC>

    @GET(GET_SINGLE_QUOTE)
    suspend fun getSingleQuote(@Path("id") id: String): Response<QuoteDC>
}
