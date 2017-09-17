package com.alexfacciorusso.daggerviewmodel

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Configures bindings to [DaggerViewModelFactory], injectable into a [ViewModelProvider.Factory].
 */
@Module
abstract class DaggerViewModelInjectionModule {
    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}