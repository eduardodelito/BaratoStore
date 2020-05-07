package com.enaz.baratostore.di

import androidx.lifecycle.ViewModel
import com.enaz.baratostore.add.AddViewModel
import com.enaz.baratostore.common.viewmodel.ViewModelKey
import com.enaz.baratostore.database.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * Created by eduardo.delito on 5/3/20.
 */
@Module
class AddViewModelModule {
    @Provides
    @IntoMap
    @ViewModelKey(AddViewModel::class)
    fun provideAddViewModel(productRepository: ProductRepository): ViewModel = AddViewModel(productRepository)
}
