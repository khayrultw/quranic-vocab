package com.khw.quranicvocab.ui.screens.tabContainer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khw.quranicvocab.ui.navigation.NestedScreen
import com.khw.quranicvocab.ui.screens.home.HomeScreen
import com.khw.quranicvocab.ui.screens.profile.ProfileScreen
import com.khw.quranicvocab.ui.screens.vocabs.VocabsScreen

@Composable
fun TabContainer(
    navController: NavController,
) {
    val nestedNavController = rememberNavController()

    val items = listOf(
        NestedScreen.Home,
        NestedScreen.Vocabs,
        NestedScreen.Profile
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by nestedNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->
                    NavigationBarItem (
                        icon = { Icon(screen.icon, "") },
                        label = { Text(stringResource(screen.resId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary
                        ),

                        onClick = {
                            nestedNavController.navigate(screen.route) {
                                popUpTo(nestedNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            nestedNavController,
            NestedScreen.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(NestedScreen.Home.route) { HomeScreen(navController) }
            composable(NestedScreen.Vocabs.route) { VocabsScreen() }
            composable(NestedScreen.Profile.route) { ProfileScreen(navController) }
        }
    }
}