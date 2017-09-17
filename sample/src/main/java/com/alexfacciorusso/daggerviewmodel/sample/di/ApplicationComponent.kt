package com.alexfacciorusso.daggerviewmodel.sample.di

import com.alexfacciorusso.daggerviewmodel.DaggerViewModelModule
import com.alexfacciorusso.daggerviewmodel.sample.SampleApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author alexfacciorusso
 */
@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, DaggerViewModelModule::class,
        MainModule::class))
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(sampleApplication: SampleApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(sampleApplication: SampleApplication)
}