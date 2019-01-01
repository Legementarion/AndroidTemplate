package com.kotlinsg.kworkshopapp.tools

import com.kotlinsg.kworkshopapp.di.Logger
import timber.log.Timber

class LoggerImpl : Logger {

    override fun d(message: String) {
        Timber.d(message)
    }

}