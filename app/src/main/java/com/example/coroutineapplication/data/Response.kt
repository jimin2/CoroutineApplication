package com.example.coroutineapplication.data

import com.google.gson.annotations.SerializedName

data class Response(
//    @SerializedName("name")
    val profile: Profile? = null
)

data class Profile(
//    @SerializedName("name")
    val name: String? = null,
    @SerializedName("age", alternate = ["age1"])
    val age: Any? = null,
//    @SerializedName("address")
    val address: String? = null
)
