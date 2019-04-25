package com.lego.template.base

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Deferred
import java.io.IOException
import kotlin.coroutines.CoroutineContext

fun <T : Any> tryHandleError(
        e: Throwable,
        coroutineContext: CoroutineContext,
        deferred: Deferred<T>,
        onSuccess: (result: T) -> Unit,
        onFailed: (errorId: Int?, errorMsg: String?) -> Unit
//        tokenErrorHandler: TokenErrorHandler
) {
//    if (e is HttpException && e.response() != null && e.response().code() == HttpCodes.UNAUTHORIZED) {
//        tokenErrorHandler.updateToken(coroutineContext, deferred, onSuccess)
//    } else if (e is CancellationException) {
//        // coroutine job was canceling by lifecycle - so we dont need to do something
//    } else {
//        parseHttpError(asRetrofitException(e), onFailed)
//    }
}

fun <T : Any> tryHandleErrorWithoutResult(
        e: Throwable,
        coroutineContext: CoroutineContext,
        deferred: Deferred<T>,
        onSuccess: () -> Unit,
        onFailed: (errorId: Int?, errorMsg: String?) -> Unit
//        tokenErrorHandler: TokenErrorHandler
) {
//    if (e is HttpException && e.response() != null && e.response().code() == HttpCodes.UNAUTHORIZED) {
//        tokenErrorHandler.updateTokenWithouResult(coroutineContext, deferred, onSuccess)
//    } else {
//        parseHttpError(asRetrofitException(e), onFailed)
//    }
}
