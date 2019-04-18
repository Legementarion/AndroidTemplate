package com.lego.template.di

import com.lego.template.tools.LoggerImpl
import com.lego.template.tools.Toaster
import com.lego.template.tools.ToasterImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val toolsModule = module {
    single<Logger> { LoggerImpl() }
    single<Toaster> { ToasterImpl(androidApplication()) }
}