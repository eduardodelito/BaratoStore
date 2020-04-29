package com.enaz.baratostore.di.component

import android.app.Application
import com.enaz.baratostore.BaratoStoreApplication
import com.enaz.baratostore.di.module.ActivityBindingModule
import com.enaz.baratostore.di.module.ViewModelBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by eduardo.delito on 4/28/20.
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityBindingModule::class, ViewModelBindingModule::class])
interface BaratoStoreComponent : AndroidInjector<BaratoStoreApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): BaratoStoreComponent
    }
}
