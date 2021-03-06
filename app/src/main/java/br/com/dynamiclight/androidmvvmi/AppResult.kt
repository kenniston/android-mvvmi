package br.com.dynamiclight.androidmvvmi

sealed class AppResult<out T: Any> {
    data class Success<out T: Any>(val data: T): AppResult<T>()
    data class Error(val error: Throwable?): AppResult<Nothing>()
}