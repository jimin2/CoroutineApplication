package com.example.coroutineapplication.data.api

import com.example.coroutineapplication.data.model.Response
import retrofit2.http.GET

interface ApiService {
//    @GET("/profile")
    @GET("/db")
    suspend fun getTEST(): Response
}