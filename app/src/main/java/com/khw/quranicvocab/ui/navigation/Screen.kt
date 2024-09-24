package com.khw.quranicvocab.ui.navigation

import androidx.annotation.DrawableRes
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
    data object Practice: Screen("practice", R.string.practice)
    data object Learn: Screen("learn", R.string.learn)
}

sealed class NestedScreen(
    val route: String,
    @StringRes val resId: Int,
    @DrawableRes val icon:  Int
) {
    data object Home: NestedScreen("home", R.string.profile, R.drawable.ic_home)
    data object Vocabs: NestedScreen("vocabs", R.string.vocabs, R.drawable.ic_list)
    data object Profile: NestedScreen("practice", R.string.profile, R.drawable.ic_profile)
}