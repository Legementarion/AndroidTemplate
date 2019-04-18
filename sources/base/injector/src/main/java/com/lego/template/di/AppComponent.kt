package com.lego.template.di

import com.lego.template.notification.di.notificationModule
import com.lego.template.repo.di.featureNetwork

val appModule = listOf(
        toolsModule,
        notificationModule,
        mainActivityModule
) + featureNetwork

