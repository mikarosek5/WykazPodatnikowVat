package com.example.wykaz_podatnikow_vat.ui.util



sealed class Data<out T : Any> {
    data class Success<out T: Any>(val response: T) : Data<T>()
    data class Error(val exception: Throwable) : Data<Nothing>()
    object Loading : Data<Nothing>()
}