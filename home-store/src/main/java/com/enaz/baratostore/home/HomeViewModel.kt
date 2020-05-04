package com.enaz.baratostore.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.enaz.baratostore.common.viewmodel.BaseViewModel
import com.enaz.baratostore.database.repository.ProductRepository
import javax.inject.Inject

class HomeViewModel@Inject constructor(private val productRepository: ProductRepository) : BaseViewModel() {

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<Int?>()
    val errorMessage: LiveData<Int?> get() = _errorMessage

    fun getProducts() = productRepository.getProducts()

    fun deleteProducts() = productRepository.deleteProducts()

    /**
     * Function to handle SearchView on text submit event
     *
     * @param query the current query string value of SearchView.
     *
     * @return false to let the SearchView perform the default action.
     */
    fun handleQueryTextSubmit(query: String?): Boolean {
        query?.let {
//            searchProduct(it)
        } ?: _errorMessage.postValue(R.string.error_empty_query)
        return false
    }

    /**
     * Function to handle SearchView on text change event
     *
     * @param newText the current string value of SearchView.
     *
     * @return false to let the SearchView perform the default action.
     */
    fun handleQueryTextChange(newText: String?): Boolean {
        if (newText.isNullOrEmpty()) {
            _errorMessage.postValue(null)
        }
        return false
    }
}
