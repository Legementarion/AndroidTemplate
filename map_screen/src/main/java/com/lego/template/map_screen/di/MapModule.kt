package com.lego.template.map_screen.di

import com.lego.template.map_screen.MapScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mapModule = module {
    viewModel { MapScreenViewModel() }
}