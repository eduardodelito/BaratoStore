package com.enaz.baratostore.di

import androidx.lifecycle.ViewModel
import com.enaz.baratostore.common.viewmodel.ViewModelKey
import com.enaz.baratostore.profile.ProfileViewModel
import com.enaz.firebase.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module
class ProfileViewModelModule {
    @Provides
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun provideHomeViewModel(profileRepository: ProfileRepository): ViewModel =
        ProfileViewModel(profileRepository)
}
