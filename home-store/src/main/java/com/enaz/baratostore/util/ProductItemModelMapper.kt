package com.enaz.baratostore.util

import com.enaz.baratostore.database.entity.ProductEntity
import com.enaz.baratostore.model.HomeProductItem

/**
 * Created by eduardo.delito on 4/29/20.
 */
fun List<ProductEntity>.entityModelToHomeProductItem() : List<HomeProductItem> {
    return this.map {
        HomeProductItem(
            name = it.name,
            description = it.description
        )
    }
}
