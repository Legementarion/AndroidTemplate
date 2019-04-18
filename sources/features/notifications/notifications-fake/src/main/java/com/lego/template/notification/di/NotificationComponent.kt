package com.lego.template.notification.di

import com.lego.template.tools.Toaster
import org.koin.dsl.module

val notificationModule = module {
    factory<NotificationUseCase> {
        object : NotificationUseCase {
            override fun showMessage() {
                get<Toaster>().show("notifications are not implemented")
            }
        }
    }
}