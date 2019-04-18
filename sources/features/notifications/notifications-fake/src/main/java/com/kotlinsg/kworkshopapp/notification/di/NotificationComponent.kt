package com.kotlinsg.kworkshopapp.notification.di

import com.kotlinsg.kworkshopapp.tools.Toaster
import org.koin.dsl.module

val notificationModule = module {
    factory {
        object :NotificationUseCase{
        override fun showMessage() {
            get<Toaster>().show("notifications are not implemented")
        }
    } }
}