package com.khw.quranicvocab.ui.screens.vocabs.viewModel

import androidx.lifecycle.ViewModel
import com.khw.quranicvocab.data.model.Vocab
import com.khw.quranicvocab.data.repo.VocabRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class VocabsViewModel @Inject constructor(
    private val repo: VocabRepo
): ViewModel() {
    fun getAllVocabs(): Flow<List<Vocab>> {
        return repo.getAll()
    }
}