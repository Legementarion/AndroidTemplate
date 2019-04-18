package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.repo.di.repositoryModule

val appModule = listOf(
        toolsModule,
        repositoryModule,
        networkModule,
        notificationModule,
        mainActivityModule
)

