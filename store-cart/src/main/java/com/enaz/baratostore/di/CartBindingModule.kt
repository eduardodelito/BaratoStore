package com.enaz.baratostore.di

import androidx.lifecycle.ViewModelProvider
import com.enaz.baratostore.cart.CartFragment
import com.enaz.baratostore.cart.CartViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module
abstract class CartBindingModule {

    @ContributesAndroidInjector(modules = [InjectCartViewModelModule::class])
    abstract fun bindCartFragment(): CartFragment

    @Module
    class InjectCartViewModelModule {
        @Provides
        internal fun provideCartViewModel(
            factory: ViewModelProvider.Factory,
            target: CartFragment
        ) = ViewModelProvider(target, factory).get(CartViewModel::class.java)
    }
}
