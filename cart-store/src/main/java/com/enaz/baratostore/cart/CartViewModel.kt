package com.enaz.baratostore.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.enaz.baratostore.common.viewmodel.BaseViewModel

class CartViewModel : BaseViewModel() {
    private val _text = MutableLiveData<String>("This is Cart screen.")
    val text: LiveData<String> get() = _text
}
