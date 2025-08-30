package com.akash.projects.data.repositoryImpl

import com.akash.projects.data.remote.ApiInterface
import com.akash.projects.domain.models.AllQuotesDC
import com.akash.projects.domain.models.QuoteDC
import com.akash.projects.domain.repository.QuoteRepository
import retrofit2.Response
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
): QuoteRepository {

    override suspend fun getAllQuotes(): Response<AllQuotesDC> {
        return apiInterface.getAllQuotes()
    }

    override suspend fun getRandomQuote(): Response<QuoteDC> {
        return apiInterface.getRandomQuotes()
    }

    override suspend fun getSingleQuote(id: String): Response<QuoteDC> {
       return apiInterface.getSingleQuote(id)
    }
}