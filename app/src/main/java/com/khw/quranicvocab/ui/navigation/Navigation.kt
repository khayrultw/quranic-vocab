package com.khw.quranicvocab.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khw.quranicvocab.ui.screens.learn.LearnScreen
import com.khw.quranicvocab.ui.screens.practice.PracticeScreen
import com.khw.quranicvocab.ui.screens.tabContainer.TabContainer

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            TabContainer(navController = navController)
        }

        composable(Screen.Practice.route) {
            PracticeScreen(navController = navController)
        }

        composable(Screen.Learn.route) {
            LearnScreen(navController = navController)
        }
    }
}