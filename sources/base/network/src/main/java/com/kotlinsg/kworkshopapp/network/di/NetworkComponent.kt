package com.kotlinsg.kworkshopapp.network.di

import com.kotlinsg.kworkshopapp.network.NetworkClient
import com.kotlinsg.kworkshopapp.network.NetworkClientImpl
import org.koin.dsl.module

val networkModule = module {
    factory<NetworkClient> { NetworkClientImpl(get()) }
}