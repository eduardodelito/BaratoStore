package com.enaz.baratostore.client.di

import com.enaz.baratostore.client.BaratoApiClient
import com.enaz.baratostore.database.dao.ProductDao
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module
class ClientModule {

    @Provides
    @Singleton
    fun provideApiClient(client: OkHttpClient.Builder) = BaratoApiClient(client)

//    @Provides
//    @Singleton
//    fun provideTrackRepository(apiClient: BaratoApiClient, productDao: ProductDao): BaratoRepository = BaratoRepositoryImpl(apiClient, productDao)
}
