package com.enaz.firebase.di

import com.enaz.firebase.repository.AuthenticationRepository
import com.enaz.firebase.repository.AuthenticationRepositoryImpl
import com.enaz.firebase.repository.ProfileRepository
import com.enaz.firebase.repository.ProfileRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Created by eduardo.delito on 5/11/20.
 */
@Module
class FireBaseModule {

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
    fun provideAuthenticationRepository(firebaseAuth: FirebaseAuth): AuthenticationRepository =
        AuthenticationRepositoryImpl(firebaseAuth)

    @Provides
    @Singleton
    fun provideProfileRepository(
        firebaseAuth: FirebaseAuth,
        firebaseStorage: FirebaseStorage
    ): ProfileRepository = ProfileRepositoryImpl(firebaseAuth, firebaseStorage)
}
