package com.enaz.baratostore.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.enaz.baratostore.common.viewmodel.BaseViewModel

class HomeViewModel : BaseViewModel() {
    private val _text = MutableLiveData<String>("This is Home screen.")
    val text: LiveData<String> get() = _text
}
