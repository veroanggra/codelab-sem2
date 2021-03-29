package com.veronica.idn.moviecatalogue.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TVViewModel : ViewModel() {
    fun init(page: Int) {
        getPopularTv(page)
    }

    private fun getPopularTv(page: Int) {
        TODO("Not yet implemented")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}