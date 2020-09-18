package com.example.coroutineapplication.module

import com.example.coroutineapplication.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule {

    @Provides
    fun provideAnalyticsService(
        // Potential dependencies of this type
    ): ApiService {
        return  Retrofit.Builder()
            .baseUrl("https://addb.interpark.com")
            .build()
            .create(ApiService::class.java)
    }
}