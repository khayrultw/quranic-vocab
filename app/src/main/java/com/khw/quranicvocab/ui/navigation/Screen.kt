package com.khw.quranicvocab.ui.navigation

import androidx.annotation.StringRes
import com.khw.quranicvocab.R

sealed class Screen(val route: String, @StringRes val resId: Int) {
    data object Home: Screen("home", R.string.home)
    data object Practice: Screen("learn", R.string.practice)
}