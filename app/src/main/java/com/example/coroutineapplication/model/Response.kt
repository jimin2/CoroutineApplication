package com.example.coroutineapplication.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("name") val title: String? = null,
    @SerializedName("age") val id: Int? = null
)
