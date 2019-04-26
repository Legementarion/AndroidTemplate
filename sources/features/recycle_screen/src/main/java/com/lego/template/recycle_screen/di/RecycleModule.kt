package com.lego.template.recycle_screen.di

import com.lego.template.recycle_screen.RecycleScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recycleModule = module {
    viewModel { RecycleScreenViewModel() }
}