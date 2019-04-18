package com.lego.template.network

import com.lego.template.GithubProject
import com.lego.template.di.Logger

interface NetworkClient {
    fun requestProject(path: String, onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
}

class NetworkClientImpl constructor(
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