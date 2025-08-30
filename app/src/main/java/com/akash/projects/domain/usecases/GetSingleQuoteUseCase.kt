package com.akash.projects.domain.usecases

import android.util.Log
import com.akash.projects.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSingleQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    operator fun invoke(quoteId: String) = flow {
        quoteRepository.getSingleQuote(quoteId).let {
            Log.e("GetSingleQuoteUseCase", "--> ${it.isSuccessful}")
            Log.e("GetSingleQuoteUseCase", "--> ${it.body().toString()}")
            if (it.isSuccessful) {
                emit(it.body())
            } else {
                emit(null)
            }
        }
    }
}