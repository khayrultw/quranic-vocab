package com.khw.quranicvocab.ui.screens.practice.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PracticeViewModel: ViewModel() {
    val state: MutableStateFlow<PracticeUiModel> = MutableStateFlow(PracticeUiModel())
}