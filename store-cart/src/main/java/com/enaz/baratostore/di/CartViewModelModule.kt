package com.enaz.baratostore.di

import androidx.lifecycle.ViewModel
import com.enaz.baratostore.cart.CartViewModel
import com.enaz.baratostore.common.viewmodel.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module
class CartViewModelModule {
    @Provides
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    fun provideCartViewModel(): ViewModel = CartViewModel()
}
