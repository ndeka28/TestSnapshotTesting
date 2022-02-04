package com.nila.testshot.di

import com.nila.testshot.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributeLoginFragment(): LoginFragment
}