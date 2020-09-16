package com.example.coroutineapplication.module

import com.example.coroutineapplication.repository.Repository
import org.koin.dsl.module

val appModule = module {

    // factory { } : 항상 새로운 인스턴스를 생성하도록 해줌

    // 싱글톤 타입으로 지정
    single { Repository(get()) }
}