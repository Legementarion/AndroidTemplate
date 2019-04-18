package com.lego.template

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.lego.template.di.appModule
import com.lego.template.tools.CrashlyticsReportingTree
import com.lego.template.tools.Toaster
import io.fabric.sdk.android.Fabric
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RealApp : Application() {

    private val toaster: Toaster by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RealApp)
            modules(appModule)
        }

        toaster.show("app started")
        initFabric()
    }

    private fun initFabric() {

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Fabric.with(this, Crashlytics())
            Timber.plant(CrashlyticsReportingTree())
        }

    }
}