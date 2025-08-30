package com.akash.projects.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.akash.projects.presentation.screens.detailscreen.DetailScreen
import com.akash.projects.presentation.screens.homescreen.HomeScreen

@Composable
fun AppNavController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenName.HOME_SCREEN) {

        composable(route = ScreenName.HOME_SCREEN) {
            HomeScreen() { id ->
                navController.navigate(ScreenName.DETAIL_SCREEN + "/$id")
            }
        }

        composable(
            route = ScreenName.DETAIL_SCREEN + "/{id}", arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                })
        ) {
            DetailScreen() {
                navController.popBackStack()
            }
        }
    }
}