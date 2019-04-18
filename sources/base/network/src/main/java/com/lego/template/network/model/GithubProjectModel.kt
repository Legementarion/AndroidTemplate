package com.lego.template.network.model

import com.lego.template.GithubProject

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