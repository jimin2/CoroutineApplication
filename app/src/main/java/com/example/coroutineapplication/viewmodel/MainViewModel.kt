package com.example.coroutineapplication.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineapplication.data.Response
import com.example.coroutineapplication.network.Result
import com.example.coroutineapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(
    private val repository: Repository
): ViewModel() {

//class MainViewModel (private val repository: Repository): ViewModel() {

    /**
     * CoroutineScope 사용시에는 백그라운드에서 해당 구문이 실행하지 않게 하기 위해서,
     * onCleared 에서 cancel 처리를 추가함
     */
//    private val job = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val _toastMsg = MutableLiveData<String>()
    val toastMsg: LiveData<String> get() = _toastMsg

    private val _resultResponse = MutableLiveData<Result<Response>>()
    val resultResponse: LiveData<Result<Response>> get() = _resultResponse

//    init {
//        viewModelScope.launch {
//            // 메인 쓰레드 작업
//            _toastMsg.value = "메인쓰레드 작업 시작"
//
//            // 백그라운드 작업
//            fetchDocs()
//
//            // 메인 쓰레드 작업
//            _toastMsg.value = "메인쓰레드 작업 종료"
//        }
//    }

//    fun loadData() = uiScope.launch {
//        // 메인 쓰레드 작업
//        _toastMsg.value = "메인쓰레드 작업 시작"
//
//        // 백그라운드 작업
//        fetchDocs()
//
//        // 메인 쓰레드 작업
//        _toastMsg.value = "메인쓰레드 작업 종료"
//    }

    /**
     * viewModelScope는 lifecycle을 인식하는 CoroutineScope 이므로
     * 별도의 처리를 하지 않아도 ViewModel이 clear 되는 순간 자동으로 취소됨
     */
    fun loadData() = viewModelScope.launch {
        // 메인 쓰레드 작업
        _toastMsg.value = "메인쓰레드 작업 시작"

        // 백그라운드 작업
        doDelay()

        apiCall()

        doDelay()

        // 메인 쓰레드 작업
        _toastMsg.value = "메인쓰레드 작업 종료"
    }

    /**
     * coroutine을 수행하는 코드를 하나의 함수로 표현하고 싶을땐, suspend 키워드를 사용
     */
    private suspend fun doDelay() = withContext(Dispatchers.Default) {
        delay(2000L)
    }

    /**
     * coroutine을 수행하는 코드를 하나의 함수로 표현하고 싶을땐, suspend 키워드를 사용
     */
    private suspend fun apiCall() = withContext(Dispatchers.IO) {
        val result = repository.getTEST()

        // setValue는 백그라운드에서 사용이 불가능하므로, postValue 사용
        _resultResponse.postValue(result)
    }

//    override fun onCleared() {
//        super.onCleared()
//        job.cancel()
//    }
}