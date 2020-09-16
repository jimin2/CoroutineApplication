package com.example.testapplication.repository

import com.example.testapplication.model.Response
import com.example.testapplication.network.ApiService

class Repository(private val webService: ApiService) {

    suspend fun getTEST(): Response {
        return webService.getTEST()
    }
}