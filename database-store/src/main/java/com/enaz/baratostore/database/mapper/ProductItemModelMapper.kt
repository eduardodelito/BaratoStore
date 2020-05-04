package com.enaz.baratostore.database.mapper

import com.enaz.baratostore.database.entity.ProductEntity
import com.enaz.baratostore.database.model.ProductItem

/**
 * Created by eduardo.delito on 4/29/20.
 */
fun List<ProductEntity>.entityModelToProductItemList() : List<ProductItem> {
    return this.map {
        ProductItem(
            name = it.name,
            description = it.description
        )
    }
}

fun List<ProductItem>.productModelToProductEntityList(): List<ProductEntity> {
    return this.map {
        ProductEntity(
            id = 0,
            name = it.name,
            description = it.description
        )
    }
}

fun ProductEntity.entityModelToProductItem() : ProductItem {
    return ProductItem(
            name = name,
            description = description
        )
}

fun ProductItem.productModelToProductEntity(): ProductEntity {
    return ProductEntity(
            id = 0,
            name = name,
            description = description
        )
}
