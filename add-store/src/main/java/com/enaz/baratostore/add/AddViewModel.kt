package com.enaz.baratostore.add

import com.enaz.baratostore.common.viewmodel.BaseViewModel
import com.enaz.baratostore.database.mapper.productModelToProductEntity
import com.enaz.baratostore.database.model.ProductItem
import com.enaz.baratostore.database.repository.ProductRepository
import javax.inject.Inject

class AddViewModel@Inject constructor(private val productRepository: ProductRepository) : BaseViewModel() {

    fun addProduct(name: String?, description: String?, listener: AddFragment.OnAddFragmentListener?) {
        productRepository.insertProduct(ProductItem(name, description).productModelToProductEntity())
        listener?.setSelectedAddMenu()
    }
}
