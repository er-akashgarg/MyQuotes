package com.akash.projects.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akash.projects.domain.models.QuoteDC
import com.akash.projects.domain.usecases.GetSingleQuoteUseCase
import com.akash.projects.network.NetworkUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val singleQuoteUseCase: GetSingleQuoteUseCase
): ViewModel() {

    var singleQuoteData = MutableStateFlow<NetworkUIState<QuoteDC?>>(NetworkUIState.LOADING())
    private set

    init {
        val id = savedStateHandle.get<String>("id")?: ""
        getSingleQuoteById(id)
    }

    private fun getSingleQuoteById(id: String) {
        singleQuoteData.tryEmit(NetworkUIState.LOADING())
        singleQuoteUseCase(quoteId = id).onEach {
            singleQuoteData.tryEmit(NetworkUIState.SUCCESS(it))
        }.launchIn(viewModelScope)
    }

}