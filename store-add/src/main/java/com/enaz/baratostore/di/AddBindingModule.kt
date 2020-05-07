package com.enaz.baratostore.di

import androidx.lifecycle.ViewModelProvider
import com.enaz.baratostore.add.AddFragment
import com.enaz.baratostore.add.AddViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by eduardo.delito on 5/3/20.
 */
@Module
abstract class AddBindingModule {

    @ContributesAndroidInjector(modules = [InjectAddViewModelModule::class])
    abstract fun bindAddFragment(): AddFragment

    @Module
    class InjectAddViewModelModule {
        @Provides
        internal fun provideAddViewModel(
            factory: ViewModelProvider.Factory,
            target: AddFragment
        ) = ViewModelProvider(target, factory).get(AddViewModel::class.java)
    }
}
