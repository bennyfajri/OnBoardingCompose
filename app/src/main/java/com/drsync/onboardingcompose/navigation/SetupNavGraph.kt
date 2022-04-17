package com.drsync.onboardingcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.drsync.onboardingcompose.screen.HomeScreen
import com.drsync.onboardingcompose.screen.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(
            route = Screen.Welcome.route
        ) {
            WelcomeScreen(navHostController = navController)
        }
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen()
        }
    }
}