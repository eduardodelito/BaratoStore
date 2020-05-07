package com.enaz.baratostore.common.di

import com.enaz.baratostore.common.manager.FirebaseAuthenticationManager
import com.enaz.baratostore.common.manager.FirebaseAuthenticationManagerImpl
import com.enaz.baratostore.common.manager.FirebaseStoreManager
import com.enaz.baratostore.common.manager.FirebaseStoreManagerImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
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
    fun firebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseAuthenticationManager(firebaseAuth: FirebaseAuth): FirebaseAuthenticationManager =
        FirebaseAuthenticationManagerImpl(firebaseAuth)

    @Provides
    @Singleton
    fun provideFirebaseStorageManager(
        firebaseAuth: FirebaseAuth,
        firebaseStorage: FirebaseStorage
    ): FirebaseStoreManager = FirebaseStoreManagerImpl(firebaseAuth, firebaseStorage)
}
