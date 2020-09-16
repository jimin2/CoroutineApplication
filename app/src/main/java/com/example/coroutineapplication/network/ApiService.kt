package com.example.coroutineapplication.network

import com.example.coroutineapplication.model.Response
import retrofit2.http.GET

interface ApiService {

    @GET("https://jimin-test.herokuapp.com/profile")
    suspend fun getTEST(): Response

}