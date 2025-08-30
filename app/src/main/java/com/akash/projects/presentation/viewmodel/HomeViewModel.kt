package com.akash.projects.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akash.projects.domain.models.HomeQuoteDC
import com.akash.projects.domain.usecases.AllQuotesUseCase
import com.akash.projects.domain.usecases.RandomQuotesUseCase
import com.akash.projects.network.NetworkUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val allQuotesUseCase: AllQuotesUseCase,
    private val randomQuotesUseCase: RandomQuotesUseCase
) : ViewModel() {

    var quotesData = MutableStateFlow<NetworkUIState<HomeQuoteDC>>(NetworkUIState.LOADING())
        private set

    init {
        getQuotes()
    }


    private fun getQuotes() {
        quotesData.tryEmit(NetworkUIState.LOADING())

        allQuotesUseCase().combine(randomQuotesUseCase()) { allQuotes, randomQuotes ->
            quotesData.tryEmit(
                NetworkUIState.SUCCESS(
                    HomeQuoteDC(
                        allQuotes = allQuotes,
                        randomQuote = randomQuotes
                    )
                )
            )
        }.launchIn(viewModelScope)
    }
}