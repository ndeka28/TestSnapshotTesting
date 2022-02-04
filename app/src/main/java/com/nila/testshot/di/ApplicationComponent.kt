package com.nila.testshot.di

import android.content.Context
import com.nila.testshot.MainApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        FragmentModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MainApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder

        fun build(): ApplicationComponent
    }
}
