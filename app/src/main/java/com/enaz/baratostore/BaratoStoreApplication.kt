package com.enaz.baratostore

import androidx.multidex.MultiDex
import com.enaz.baratostore.common.di.NetworkModule
import com.enaz.baratostore.database.di.DatabaseModule
import com.enaz.baratostore.di.component.DaggerBaratoStoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by eduardo.delito on 4/28/20.
 */
class BaratoStoreApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerBaratoStoreComponent
            .builder()
            .application(this)
            .network(NetworkModule())
            .database(DatabaseModule(this))
            .build()
    }
}
