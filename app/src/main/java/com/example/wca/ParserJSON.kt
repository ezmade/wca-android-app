package com.example.wca

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response
import retrofit2.http.Path

data class User(
    val wca_id: String? = null,
    val name: String = "",
    val avatar: Avatar = Avatar()
)

data class JSON_User(
    val user: User = User()
)



data class JSON_Person(
    val person: Person = Person(),
    val competition_count: Int = 0,
    val medals: Medals = Medals(),
    val records: Records = Records()
)

data class Person(
    val wca_id: String? = null,
    val name: String = "",
    val url: String = "",
    val avatar: Avatar = Avatar()
)

data class Records(
    val national: Int = 0,
    val continental: Int = 0,
    val world: Int = 0,
    val total: Int = 0
)

data class Medals(
    val gold: Int = 0,
    val silver: Int = 0,
    val bronze: Int = 0,
    val total: Int = 0
)

data class Avatar(
    val url: String = "",
    val thumb_url: String = ""
)

interface WCAApi {
    @GET("/users/{id}")
    suspend fun getUser(@Path("user_id") id: Int): Response<JSON_User>
}

fun getJSON_Person(wcaID: String? = null): String?  {
    val string: String? = null
    return string
}