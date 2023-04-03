package com.waire.cdetect.android.ui.viewmodel

sealed class UiResult<out T : Any> {
    data class Success<out T : Any>(val data: T): UiResult<T>()
    data class Error(val error: Exception): UiResult<Nothing>()
}

inline fun <T, R : Any> T.runCatching(block: T.() -> R): UiResult<R> {
    return try {
        UiResult.Success(block())
    } catch (e: Exception) {
        UiResult.Error(e)
    }
}
