package com.enaz.baratostore.di.module

import com.enaz.baratostore.MainActivity
import com.enaz.baratostore.di.*
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
            AddBindingModule::class,
            FeedBindingModule::class,
            ProfileBindingModule::class,
            CartBindingModule::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity
}
