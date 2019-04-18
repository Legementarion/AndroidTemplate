package com.lego.template.repo.di

import com.lego.template.network.di.networkModule
import com.lego.template.repo.GithubRepo
import com.lego.template.repo.GithubRepoImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<GithubRepo> { GithubRepoImpl(get(), get()) }
}

val featureNetwork = listOf(repositoryModule, networkModule)
