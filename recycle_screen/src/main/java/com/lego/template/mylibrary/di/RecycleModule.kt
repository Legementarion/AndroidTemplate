package com.lego.template.mylibrary.di

import com.lego.template.mylibrary.RecycleScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recycleModule = module {
    viewModel { RecycleScreenViewModel() }
}