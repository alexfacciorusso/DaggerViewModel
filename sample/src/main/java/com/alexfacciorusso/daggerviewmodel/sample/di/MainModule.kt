package com.alexfacciorusso.daggerviewmodel.sample.di

import android.arch.lifecycle.ViewModel
import com.alexfacciorusso.daggerviewmodel.ViewModelKey
import com.alexfacciorusso.daggerviewmodel.sample.MainActivity
import com.alexfacciorusso.daggerviewmodel.sample.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author alexfacciorusso
 */
@Module
abstract class MainModule {
    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel
}