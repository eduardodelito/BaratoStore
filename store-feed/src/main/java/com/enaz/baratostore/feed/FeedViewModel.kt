package com.enaz.baratostore.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.enaz.baratostore.common.viewmodel.BaseViewModel

class FeedViewModel : BaseViewModel() {
    private val _text = MutableLiveData<String>("This is Feed screen.")
    val text: LiveData<String> get() = _text
}