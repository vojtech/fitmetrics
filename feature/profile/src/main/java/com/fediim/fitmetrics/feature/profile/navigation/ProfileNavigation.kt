package com.fediim.fitmetrics.feature.profile.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.fediim.fitmetrics.feature.profile.ui.ProfileScreen

object ProfileDestinations {
    const val PROFILE_ROUTE = "profile"
}

fun NavGraphBuilder.profileGraph(navController: NavHostController) {
    composable(ProfileDestinations.PROFILE_ROUTE) {
        ProfileScreen(onNavigateBack = { navController.popBackStack() })
    }
}

fun NavHostController.navigateToProfile() {
    this.navigate(ProfileDestinations.PROFILE_ROUTE)
}
