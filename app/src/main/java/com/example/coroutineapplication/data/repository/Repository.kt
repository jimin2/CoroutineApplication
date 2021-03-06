package com.example.coroutineapplication.data.repository

import com.example.coroutineapplication.data.model.Response
import com.example.coroutineapplication.data.api.ApiHelper
import com.example.coroutineapplication.data.Result
import javax.inject.Inject

class Repository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getTEST(): Result<Response> {
        val data = apiHelper.getTEST()

        return if (data.profile == null || data.profile.name.isNullOrEmpty()) {
            Result.Error("API 조회 오류")
        } else {
            Result.Success(data)
        }
    }
}