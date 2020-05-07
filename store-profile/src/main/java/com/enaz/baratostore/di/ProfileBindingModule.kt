package com.enaz.baratostore.di

import androidx.lifecycle.ViewModelProvider
import com.enaz.baratostore.profile.ProfileFragment
import com.enaz.baratostore.profile.ProfileViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module
abstract class ProfileBindingModule {

    @ContributesAndroidInjector(modules = [InjectProfileViewModelModule::class])
    abstract fun bindProfileFragment(): ProfileFragment

    @Module
    class InjectProfileViewModelModule {
        @Provides
        internal fun provideProfileViewModel(
            factory: ViewModelProvider.Factory,
            target: ProfileFragment
        ) = ViewModelProvider(target, factory).get(ProfileViewModel::class.java)
    }
}
