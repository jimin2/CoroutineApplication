package com.example.coroutineapplication.model

import com.google.gson.annotations.SerializedName

data class Response(
//    @SerializedName("name")
    val profile: Profile? = null
)

data class Profile(
//    @SerializedName("name")
    val name: String? = null,
//    @SerializedName("age")
    val age: Int? = null,
//    @SerializedName("address")
    val address: String? = null
)
