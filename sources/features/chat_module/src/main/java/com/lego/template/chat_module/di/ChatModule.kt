package com.lego.template.chat_module.di

import com.lego.template.chat_module.ChatScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chatModule = module {
    viewModel { ChatScreenViewModel() }
}