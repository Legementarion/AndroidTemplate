package com.kotlinsg.kworkshopapp.network.model

import com.google.gson.Gson
import com.kotlinsg.kworkshopapp.GithubProject
import java.io.Reader

data class GithubProjectModel(
        override val name: String = "",
        override val stargazersCount: Int = 0,
        override val forksCount: Int = 0
) : GithubProject {

    class Deserializer
//        : ResponseDeserializable<GithubProjectModel> {
//        override fun deserialize(reader: Reader): GithubProjectModel = Gson().fromJson(reader, GithubProjectModel::class.java)
//    }
}