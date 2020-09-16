package com.example.testapplication.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("posts") val posts: List<Posts>? = null
)

data class Posts(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("content") val content: String? = null
)
