package com.enaz.baratostore.di.component

import android.app.Application
import com.enaz.baratostore.BaratoStoreApplication
import com.enaz.baratostore.client.di.ClientModule
import com.enaz.baratostore.common.di.NetworkModule
import com.enaz.baratostore.database.di.DatabaseModule
import com.enaz.baratostore.di.module.ActivityBindingModule
import com.enaz.baratostore.di.module.AppModule
import com.enaz.baratostore.di.module.ViewModelBindingModule
import com.enaz.firebase.di.FireBaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by eduardo.delito on 4/28/20.
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBindingModule::class,
    ViewModelBindingModule::class,
    AppModule::class
])
interface BaratoStoreComponent : AndroidInjector<BaratoStoreApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun network(networkModule: NetworkModule): Builder
        fun database(databaseModule: DatabaseModule): Builder
        fun client(clientModule: ClientModule): Builder
        fun firebase(fireBaseModule: FireBaseModule): Builder
        fun build(): BaratoStoreComponent
    }
}
