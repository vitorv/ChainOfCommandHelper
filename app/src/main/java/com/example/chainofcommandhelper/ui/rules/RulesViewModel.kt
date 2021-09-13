package com.example.chainofcommandhelper.ui.rules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RulesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is rules Fragment"
    }
    val text: LiveData<String> = _text
}