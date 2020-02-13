package com.example.wca

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
    val wca_id: String = "",
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
