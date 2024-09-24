package com.khw.quranicvocab.ui.screens.practice.viewModel

import com.khw.quranicvocab.data.model.Vocab

data class PracticeUiModel(
    val vocab: Vocab = Vocab(id = 0, word = "Word", meanings = "Meanings"),
    val doneCount: Int = 1,
    val currentIndex: Int = 0,
    val error: String? = null
)