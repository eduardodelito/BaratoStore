package com.enaz.baratostore.di.module

import com.enaz.baratostore.MainActivity
import com.enaz.baratostore.di.CartBindingModule
import com.enaz.baratostore.di.FeedBindingModule
import com.enaz.baratostore.di.HomeBindingModule
import com.enaz.baratostore.di.ProfileBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by eduardo.delito on 4/28/20.
 */
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(
        modules = [
            HomeBindingModule::class,
            FeedBindingModule::class,
            ProfileBindingModule::class,
            CartBindingModule::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity
}
