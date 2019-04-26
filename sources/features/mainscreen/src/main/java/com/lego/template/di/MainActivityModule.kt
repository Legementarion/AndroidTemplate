package com.lego.template.di

import com.lego.template.chat_module.di.chatModule
import com.lego.template.home.HomeViewModel
import com.lego.template.map_screen.di.mapModule
import com.lego.template.recycle_screen.di.recycleModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainActivityModule = module {
    viewModel { HomeViewModel() }
}

val featureUI = listOf(mainActivityModule, chatModule, mapModule, recycleModule)