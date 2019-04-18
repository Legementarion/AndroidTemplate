package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.repo.GithubRepo
import com.kotlinsg.kworkshopapp.tools.Toaster

interface MainToolsProvider {
    fun provideLogger(): Logger
    fun provideToast(): Toaster
}

interface RepoProvider {
    fun provideGithubRepo(): GithubRepo
}