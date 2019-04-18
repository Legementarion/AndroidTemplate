package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.tools.LoggerImpl
import com.kotlinsg.kworkshopapp.tools.Toaster
import com.kotlinsg.kworkshopapp.tools.ToasterImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val toolsModule = module {
    single<Logger> { LoggerImpl() }
    single<Toaster> { ToasterImpl(androidApplication()) }
}