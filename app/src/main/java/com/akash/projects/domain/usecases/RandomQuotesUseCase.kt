package com.akash.projects.domain.usecases

import com.akash.projects.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RandomQuotesUseCase @Inject constructor(
    private val quotesRepository: QuoteRepository
) {
    operator fun invoke() = flow {
        quotesRepository.getRandomQuote().let {
            if (it.isSuccessful) {
                emit(it.body())
            }
        }
    }
}