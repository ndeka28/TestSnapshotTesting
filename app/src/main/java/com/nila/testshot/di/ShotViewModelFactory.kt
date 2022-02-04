package com.nila.testshot.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nila.testshot.LoginViewModel
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ShotViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>,
        @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  viewModels[modelClass]?.get() as T
    }
}

