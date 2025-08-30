package com.akash.projects.network

sealed class NetworkUIState<T> {

    class LOADING<T>() : NetworkUIState<T>()

    data class SUCCESS<T>(val data: T) : NetworkUIState<T>()

    data class ERROR<T>(val message: Any) : NetworkUIState<T>()

}