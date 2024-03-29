package com.enaz.baratostore.di.module

import androidx.lifecycle.ViewModelProvider
import com.enaz.baratostore.common.viewmodel.ViewModelFactory
import com.enaz.baratostore.di.*
import dagger.Binds
import dagger.Module

/**
 * Created by eduardo.delito on 4/28/20.
 */
@Module(
    includes = [
        HomeViewModelModule::class,
        AddViewModelModule::class,
        FeedViewModelModule::class,
        ProfileViewModelModule::class,
        CartViewModelModule::class
    ]
)
abstract class ViewModelBindingModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
