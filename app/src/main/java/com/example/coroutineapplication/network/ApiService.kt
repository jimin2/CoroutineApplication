package com.example.coroutineapplication.network

import com.example.coroutineapplication.data.Response
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.http.GET

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface ApiService {

//    @GET("https://jimin-test.herokuapp.com/profile")
    @GET("https://jimin-test.herokuapp.com/db")
    suspend fun getTEST(): Response?
}