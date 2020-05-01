package com.enaz.baratostore.database.di

import android.app.Application
import androidx.room.Room
import com.enaz.baratostore.database.BaratoStoreDatabase
import com.enaz.baratostore.database.dao.ProductDao
import com.enaz.baratostore.database.repository.ProductRepository
import com.enaz.baratostore.database.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Module
class DatabaseModule(private val mApplication: Application) {

    private var baratoStoreDatabase: BaratoStoreDatabase

    init {
        synchronized(this) {
            val instance = Room.databaseBuilder(
                mApplication,
                BaratoStoreDatabase::class.java,
                BaratoStoreDatabase.DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
            baratoStoreDatabase = instance
            instance
        }
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): BaratoStoreDatabase {
        return baratoStoreDatabase
    }

    @Singleton
    @Provides
    fun providesProductDao(baratoStoreDatabase: BaratoStoreDatabase): ProductDao {
        return baratoStoreDatabase.productDao()
    }

    @Provides
    @Singleton
    fun provideProductRepository(productDao: ProductDao): ProductRepository =
        ProductRepositoryImpl(productDao)
}
