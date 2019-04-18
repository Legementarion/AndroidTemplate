package com.lego.template.tools

import com.lego.template.di.Logger
import timber.log.Timber

class LoggerImpl : Logger {

    override fun d(message: String) {
        Timber.d(message)
    }

}