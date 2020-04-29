package com.enaz.baratostore.di.module

import com.enaz.baratostore.common.di.NetworkModule
import com.enaz.baratostore.database.di.DatabaseModule
import dagger.Module

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module(
    includes = [
        NetworkModule::class, DatabaseModule::class
    ]
)
class AppModule
