package com.unos.finends.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseUser
import com.unos.finends.auth
import com.unos.finends.data.model.NavigationItems
import com.unos.finends.screen.HistoryScreen
import com.unos.finends.screen.StatisticScreen

@Composable
fun BottomNavbar(navController: NavHostController) {

    val navigationItems = listOf(
        NavigationItems.Home,
        NavigationItems.History,
        NavigationItems.Statistic,
        NavigationItems.Profile
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination?.route
                navigationItems.forEach { navItem ->
                    NavigationBarItem(
                        icon = {
                            Image(
                                painter = painterResource(id = navItem.icon),
                                contentDescription = navItem.name
                            )
                        },
                        selected = currentDestination == navItem.route,
                        onClick = {
                            navController.navigate(navItem.route){
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }

//                            if (currentDestination != navItem.route) {
//                                navController.navigate(navItem.route) {
//                                    popUpTo(navController.graph.startDestinationId) {
//                                        saveState = true
//                                    }
//                                    launchSingleTop = true
//                                    restoreState = true
//                                }
//                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavigationItems.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(NavigationItems.Home.route) {
                HomeScreen(currentUser = auth.currentUser) {
                    navController.navigate(NavigationItems.Profile.route)
                }
            }
            composable(NavigationItems.Statistic.route) {
                StatisticScreen()
            }
            composable(NavigationItems.History.route) {
                HistoryScreen()
            }
        }
    }

}
