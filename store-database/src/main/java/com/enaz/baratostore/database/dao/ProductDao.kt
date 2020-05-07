package com.enaz.baratostore.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.enaz.baratostore.database.entity.ProductEntity
import io.reactivex.Single

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productEntity: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(productList: List<ProductEntity>)

    @Query("SELECT * from ProductEntity ORDER BY id ASC")
    fun getProducts() : LiveData<List<ProductEntity>>

    @Query("DELETE FROM ProductEntity")
    fun deleteAll()
}
