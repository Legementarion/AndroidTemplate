package com.kotlinsg.kworkshopapp

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.kotlinsg.kworkshopapp.di.AppComponent
import com.kotlinsg.kworkshopapp.di.ApplicationProvider
import com.kotlinsg.kworkshopapp.tools.CrashlyticsReportingTree
import com.kotlinsg.kworkshopapp.tools.Toaster
import io.fabric.sdk.android.Fabric
import timber.log.Timber
import javax.inject.Inject

class RealApp : Application(), App {

    @Inject lateinit var toaster: Toaster
    private val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this@RealApp) }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        toaster.show("app injected")
    }

    private fun initFabric() {

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Fabric.with(this, Crashlytics())
            Timber.plant(CrashlyticsReportingTree())
        }

    }

    override fun getAppComponent(): ApplicationProvider = appComponent
}