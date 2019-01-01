package com.kotlinsg.kworkshopapp.tools

import android.util.Log
import com.crashlytics.android.Crashlytics
import timber.log.Timber

class CrashlyticsReportingTree : Timber.Tree() {

    companion object {
        const val MIN_LOG_PRIORITY = Log.ERROR
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority < MIN_LOG_PRIORITY) {
            return
        }
        Crashlytics.log(priority, tag, message)
        t?.let {
            Crashlytics.logException(it)
        }
    }
}