package com.enaz.baratostore.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by eduardo.delito on 4/29/20.
 */
@Entity(tableName = "ProductEntity")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "description") var description: String?
)
