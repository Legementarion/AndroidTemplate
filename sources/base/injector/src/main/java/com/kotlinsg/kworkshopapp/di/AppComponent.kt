package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.notification.di.notificationModule
import com.kotlinsg.kworkshopapp.repo.di.featureNetwork

val appModule = listOf(
        toolsModule,
        notificationModule,
        mainActivityModule
) + featureNetwork

