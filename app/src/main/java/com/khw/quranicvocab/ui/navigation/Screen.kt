package com.khw.quranicvocab.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.khw.quranicvocab.R

sealed class Screen(val route: String, @StringRes val resId: Int) {
    data object Home: Screen("home", R.string.home)
    data object Practice: Screen("learn", R.string.practice)
}

sealed class NestedScreen(
    val route: String,
    @StringRes val resId: Int,
    val icon: ImageVector
) {
    data object Home: NestedScreen("home", R.string.profile, Icons.Default.Home)
    data object Vocabs: NestedScreen("vocabs", R.string.vocabs, Icons.Default.Book)
    data object Profile: NestedScreen("practice", R.string.profile, Icons.Default.Person)
}