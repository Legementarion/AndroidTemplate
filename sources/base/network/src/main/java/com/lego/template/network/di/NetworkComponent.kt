package com.lego.template.network.di

import com.lego.template.network.NetworkClient
import com.lego.template.network.NetworkClientImpl
import org.koin.dsl.module

val networkModule = module {
    factory<NetworkClient> { NetworkClientImpl(get()) }
}