package com.enaz.baratostore.common.di

import com.enaz.baratostore.common.manager.FirebaseAuthenticationManager
import com.enaz.baratostore.common.manager.FirebaseAuthenticationManagerImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideHttpClientBuilder() = OkHttpClient.Builder()

    @Provides
    @Singleton
    fun firebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun firebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseAuthenticationManager(firebaseAuth: FirebaseAuth): FirebaseAuthenticationManager =
        FirebaseAuthenticationManagerImpl(firebaseAuth)
}
