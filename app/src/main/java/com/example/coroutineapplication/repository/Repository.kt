package com.example.coroutineapplication.repository

import com.example.coroutineapplication.model.Response
import com.example.coroutineapplication.network.ApiService

class Repository(private val webService: ApiService) {

    suspend fun getTEST(): Response {
        return webService.getTEST()
    }
}