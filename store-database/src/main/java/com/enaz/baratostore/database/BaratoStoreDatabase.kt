package com.enaz.baratostore.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enaz.baratostore.database.dao.ProductDao
import com.enaz.baratostore.database.entity.ProductEntity

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class BaratoStoreDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        const val DB_NAME = "DBBaratoStore"
    }
}
