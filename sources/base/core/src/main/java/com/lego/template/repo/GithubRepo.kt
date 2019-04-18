package com.lego.template.repo

import com.lego.template.GithubProject

interface GithubRepo {
    fun getSampleProject(onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
}