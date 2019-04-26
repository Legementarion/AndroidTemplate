package com.lego.template.base.coroutines

import com.lego.template.base.tryHandleError
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun <T, R> zip(
        coroutineContext: CoroutineContext,
        deferred1: Deferred<T>,
        deferred2: Deferred<R>,
        onSuccess: (result: Pair<T, R>) -> Unit,
        onFailed: (errorId: Int?, errorMsg: String?) -> Unit
): Job {
    return CoroutineScope(coroutineContext).launch {
        try {
            val result1 = deferred1.await()
            val result2 = deferred2.await()
            onSuccess(Pair(result1, result2))
        } catch (e: Exception) {
            e.printStackTrace()
//            tryHandleError(e = e, onFailed = onFailed)
        }
    }
}

fun <R : Any, T : Deferred<R>> T.runAsync(
        coroutineContext: CoroutineContext,
        onSuccess: (result: R) -> Unit,
        onFailed: (errorId: Int?, errorMsg: String?) -> Unit
): Job {
    return CoroutineScope(coroutineContext).launch {
        try {
            val result = this@runAsync.await()
            onSuccess(result)
        } catch (e: Throwable) {
            e.printStackTrace()
//           todo  tryHandleError
        }
    }
}

fun <R : Any, T : Deferred<R>> T.runWithoutResultAsync(
        coroutineContext: CoroutineContext,
        onSuccess: () -> Unit,
        onFailed: (errorId: Int?, errorMsg: String?) -> Unit
): Job {
    return CoroutineScope(coroutineContext).launch {
        try {
            this@runWithoutResultAsync.await()
            onSuccess()
        } catch (e: Throwable) {
            e.printStackTrace()
//           todo  tryHandleError
        }
    }
}