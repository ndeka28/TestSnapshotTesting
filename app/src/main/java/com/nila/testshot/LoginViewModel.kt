package com.nila.testshot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

@OpenForTesting
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _loginState = MutableLiveData<Boolean>()
    val loginState : LiveData<Boolean>
        get() = _loginState

    fun login() {
        Thread(Runnable {
            Thread.sleep(300)
            _loginState.postValue(true)
        }).start()
    }
}