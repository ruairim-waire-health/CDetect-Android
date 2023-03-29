package com.waire.cdetect.domain.model

sealed class CResult<out T : Any> {
    data class Success<out T : Any>(val data: T): CResult<T>()
    data class Error(val error: Exception): CResult<Nothing>()
}

inline fun <T, R : Any> T.runCatching(block: T.() -> R): CResult<R> {
    return try {
        CResult.Success(block())
    } catch (e: Exception) {
        CResult.Error(e)
    }
}
