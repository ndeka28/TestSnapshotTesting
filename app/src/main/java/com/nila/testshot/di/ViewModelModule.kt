package com.nila.testshot.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nila.testshot.LoginViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ShotViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun splashViewModel(viewModel: LoginViewModel): ViewModel
}

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)