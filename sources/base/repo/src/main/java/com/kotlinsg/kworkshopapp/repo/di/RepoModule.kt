package com.kotlinsg.kworkshopapp.repo.di

import com.kotlinsg.kworkshopapp.repo.GithubRepo
import com.kotlinsg.kworkshopapp.repo.GithubRepoImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<GithubRepo> { GithubRepoImpl(get(), get()) }
}