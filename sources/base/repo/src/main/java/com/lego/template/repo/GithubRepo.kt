package com.lego.template.repo

import com.lego.template.GithubProject
import com.lego.template.di.Logger
import com.lego.template.network.NetworkClient

class GithubRepoImpl constructor(
        private val client: NetworkClient,
        private val logger: Logger
) : GithubRepo {

    override fun getSampleProject(onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit) {
        logger.d("requested  project")
        client.requestProject("kotlinsg/KWorkshopApp", onResult, onError)
    }

}