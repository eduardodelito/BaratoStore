package com.enaz.baratostore.di

import androidx.lifecycle.ViewModelProvider
import com.enaz.baratostore.home.HomeFragment
import com.enaz.baratostore.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by eduardo.delito on 4/28/20.
 */
@Module
abstract class HomeBindingModule {

    @ContributesAndroidInjector(modules = [InjectHomeViewModelModule::class])
    abstract fun bindHomeFragment(): HomeFragment

    @Module
    class InjectHomeViewModelModule {
        @Provides
        internal fun provideHomeViewModel(
            factory: ViewModelProvider.Factory,
            target: HomeFragment
        ) = ViewModelProvider(target, factory).get(HomeViewModel::class.java)
    }
}
