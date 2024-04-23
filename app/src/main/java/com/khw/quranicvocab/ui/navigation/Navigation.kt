package com.khw.quranicvocab.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khw.quranicvocab.ui.screens.home.Home
import com.khw.quranicvocab.ui.screens.practice.Practice

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            Home(navController = navController)
        }

        composable(Screen.Practice.route) {
            Practice(navController = navController)
        }
    }
}