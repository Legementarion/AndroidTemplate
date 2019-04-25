package com.lego.template.network.utils

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.lego.template.network.R
import java.io.IOException

fun parseHttpError(e: Exception, onFailed: (errorId: Int?, errorMsg: String?) -> Unit) {
    val error = e as NetworkException
    var errorResId: Int? = null
    var errorMsg = ""

    when (error.kind) {
        NetworkException.Kind.HTTP -> {
            val response = error.response
//            if (response != null && response.code() == HttpCodes.UNAUTHORIZED) {
//                errorResId = R.string.ERROR_USER_IS_UNAUTHORIZED
//            } else {
//                try {
//                    val errorMessage = error.errorBody?.errorMessage
//                    if (!errorMessage.isNullOrEmpty()) {
//                        errorMsg = errorMessage
//                        errorResId = convertServerErrorMessageToStringRes(errorMsg)
//                        if (errorMsg == ServerError.TRIAL_PERIOD_IS_EXPIRED
//                                || errorMsg == ServerError.MONTHLY_FEE_IS_EXPIRED
//                                || errorMsg == ServerError.APPLICATION_IS_STOPPED) {
//                        }
//                    }
//                } catch (ignored: IOException) {
//                    errorResId = R.string.ERROR_AN_INTERNAL_SERVER_ERROR
//                }
            }
        NetworkException.Kind.NETWORK -> {
//        errorResId = R.string.ERROR_NO_NETWORK
    }
        NetworkException.Kind.UNEXPECTED -> {
        }
    }

    onFailed(errorResId, errorMsg)
}

fun asNetworkException(throwable: Throwable): NetworkException {
    // We had non-200 http error
    if (throwable is HttpException) {
        val response = throwable.response()
        return NetworkException.httpError(response.raw().request().url().toString(), response)
    }
    // A network error happened
    return if (throwable is IOException) {
        NetworkException.networkError(throwable)
    } else NetworkException.unexpectedError(throwable)

    // We don't know what happened. We need to simply convert to an unknown error
}