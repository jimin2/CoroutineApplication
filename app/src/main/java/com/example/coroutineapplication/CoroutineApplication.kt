package com.example.coroutineapplication

import android.app.Application
import com.example.coroutineapplication.module.appModule
import com.example.coroutineapplication.module.retrofitModule
import com.example.coroutineapplication.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CoroutineApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {

            androidLogger(Level.ERROR)

            androidContext(this@CoroutineApplication)

            modules(
                retrofitModule,
                appModule,
                viewModelModule
            )
        }
    }
}