package com.example.coroutineapplication.di.module

import com.example.coroutineapplication.data.repository.Repository
import org.koin.dsl.module

// koin에서 사용
val appModule = module {

    // factory { } : 항상 새로운 인스턴스를 생성하도록 해줌

    // 싱글톤 타입으로 지정
    single { Repository(get()) }
}