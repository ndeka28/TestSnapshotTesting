package com.nila.testshot

import android.app.Application
import com.nila.testshot.di.ApplicationComponent
import com.nila.testshot.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector

open class MainApp : DaggerApplication(), HasAndroidInjector {
    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
            applicationComponent = DaggerApplicationComponent.builder().application(this).build()
            return applicationComponent
    }
}