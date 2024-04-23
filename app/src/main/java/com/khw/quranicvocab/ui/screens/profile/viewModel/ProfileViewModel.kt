package com.khw.quranicvocab.ui.screens.profile.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel: ViewModel() {
    val state = MutableStateFlow("Hello Compose UI from Review")
}