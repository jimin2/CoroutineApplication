package com.example.coroutineapplication.repository

import com.example.coroutineapplication.data.Response
import com.example.coroutineapplication.network.ApiService
import com.example.coroutineapplication.network.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val webService: ApiService) {

    suspend fun getTEST(): Result<Response> {
        val data = webService.getTEST()

        return if (data.profile == null || data.profile.name.isNullOrEmpty()) {
            Result.Error("API 조회 오류")
        } else {
            Result.Success(data)
        }
    }
}