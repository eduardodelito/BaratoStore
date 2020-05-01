package com.enaz.baratostore.database.repository

import androidx.lifecycle.LiveData
import com.enaz.baratostore.database.dao.ProductDao
import com.enaz.baratostore.database.entity.ProductEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Created by eduardo.delito on 5/1/20.
 */
interface ProductRepository {

    fun getProducts() : LiveData<List<ProductEntity>>

    fun insertProducts(productList: List<ProductEntity>)

    fun deleteProducts()
}

class ProductRepositoryImpl(private val productDao: ProductDao) : ProductRepository, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun getProducts() = productDao.getProducts()

    override fun insertProducts(productList: List<ProductEntity>) {
        launch { insertProductsBG(productList) }
    }

    private suspend fun insertProductsBG(productList: List<ProductEntity>) {
        withContext(Dispatchers.IO) {
            productDao.insertProducts(productList)
        }
    }

    override fun deleteProducts() {
        launch { deleteProductsBG() }
    }

    private suspend fun deleteProductsBG() {
        withContext(Dispatchers.IO) {
            productDao.deleteAll()
        }
    }
}
