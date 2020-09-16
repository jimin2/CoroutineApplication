package com.example.testapplication.module

import com.example.testapplication.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

// ViewModel 에 대한 모듈
val viewModelModule = module {
    // MyViewModel ViewModel
    viewModel { MainViewModel(get()) }
}