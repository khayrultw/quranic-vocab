package com.khw.quranicvocab.ui.screens.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val state = MutableStateFlow(0)
    val finished = MutableSharedFlow<Unit>()

    fun test() {
        viewModelScope.launch(Dispatchers.IO) {
            finished.emit(Unit)
        }
    }
}