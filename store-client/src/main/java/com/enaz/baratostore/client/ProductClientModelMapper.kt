package com.enaz.baratostore.client

import com.enaz.baratostore.client.model.ProductResponse
import com.enaz.baratostore.database.entity.ProductEntity

/**
 * Created by eduardo.delito on 4/29/20.
 */
fun List<ProductResponse>.serviceModelToProductEntity(): List<ProductEntity> {
    return this.map {
        ProductEntity(
            id = 0,
            name = it.name,
            description = it.description
        )
    }
}
