package com.example.testapplication

import android.app.Application
import com.example.testapplication.module.appModule
import com.example.testapplication.module.retrofitModule
import com.example.testapplication.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {

            androidLogger(Level.ERROR)

            androidContext(this@TestApplication)

            modules(
                retrofitModule,
                appModule,
                viewModelModule
            )
        }
    }
}