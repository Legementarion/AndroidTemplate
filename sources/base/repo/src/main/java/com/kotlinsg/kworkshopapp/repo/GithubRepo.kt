package com.kotlinsg.kworkshopapp.repo

import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.di.Logger
import com.kotlinsg.kworkshopapp.network.NetworkClient
import javax.inject.Inject

class GithubRepoImpl @Inject constructor(
        private val client: NetworkClient,
        private val logger: Logger
) : GithubRepo {

    override fun getSampleProject(onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit) {
        logger.d("requested  project")
        client.requestProject("kotlinsg/KWorkshopApp", onResult, onError)
    }

}