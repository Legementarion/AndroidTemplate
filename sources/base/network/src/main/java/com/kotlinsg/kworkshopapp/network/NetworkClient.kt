package com.kotlinsg.kworkshopapp.network

import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.di.Logger
import javax.inject.Inject

interface NetworkClient {
    fun requestProject(path: String, onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
}

class NetworkClientImpl @Inject constructor(
        private val logger: Logger
) : NetworkClient {

    override fun requestProject(path: String, onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit) {

        val url = "https://api.github.com/repos/$path"

        logger.d("requesting: $url")

//        url.httpGet().responseObject(
//                deserializer = GithubProjectModel.Deserializer())
//        { _: Request, _: Response, (result, error): Result<GithubProjectModel, FuelError> ->
//
//            result?.let(onResult)
//            error?.let(onError)
//        }
    }
}