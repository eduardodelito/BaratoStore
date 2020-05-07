package com.enaz.baratostore.di

import androidx.lifecycle.ViewModel
import com.enaz.baratostore.common.viewmodel.ViewModelKey
import com.enaz.baratostore.database.repository.ProductRepository
import com.enaz.baratostore.home.HomeViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * Created by eduardo.delito on 4/28/20.
 */
@Module
class HomeViewModelModule {
    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun provideHomeViewModel(productRepository: ProductRepository, firebaseAuth: FirebaseAuth): ViewModel = HomeViewModel(productRepository, firebaseAuth)
}
