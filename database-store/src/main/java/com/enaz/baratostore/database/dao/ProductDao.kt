package com.enaz.baratostore.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.enaz.baratostore.database.entity.ProductEntity
import io.reactivex.Single

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Dao
interface ProductDao {
    @Query("SELECT * FROM ProductEntity")
    fun getAllProducts(): Single<List<ProductEntity>>
}
