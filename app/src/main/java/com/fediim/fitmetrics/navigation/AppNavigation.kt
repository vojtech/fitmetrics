package com.fediim.fitmetrics.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fediim.fitmetrics.feature.activitylog.navigation.ActivityLogDestinations
import com.fediim.fitmetrics.feature.activitylog.navigation.activityLogGraph
import com.fediim.fitmetrics.feature.activitylog.navigation.navigateToActivityLogList
import com.fediim.fitmetrics.feature.authentication.AuthScreen
import com.fediim.fitmetrics.feature.authentication.AuthViewModel
import com.fediim.fitmetrics.feature.authentication.state.AuthState
import com.fediim.fitmetrics.feature.profile.navigation.ProfileDestinations
import com.fediim.fitmetrics.feature.profile.navigation.profileGraph

object AppDestinations {
    const val AUTH_ROUTE = "auth"
}

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel
) {
    val authState by authViewModel.uiState.collectAsState()

    LaunchedEffect(authState) {
        if (authState is AuthState.Authenticated &&
            navController.currentDestination?.route == AppDestinations.AUTH_ROUTE
        ) {
            navController.navigateToActivityLogList()
        }
    }

    // Determine start destination based on auth state
    val startDestination =
        if (authState is AuthState.Authenticated) {
            ActivityLogDestinations.ACTIVITY_LOG_LIST_ROUTE
        } else {
            AppDestinations.AUTH_ROUTE
        }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = AppDestinations.AUTH_ROUTE) {
            AuthScreen(
                onAuthSuccess = { /* Navigation handled by LaunchedEffect */ },
                modifier = Modifier
            )
        }

        // Activity log graph with hook to navigate to profile
        activityLogGraph(
            navController,
            onNavigateToProfile = { navController.navigate(ProfileDestinations.PROFILE_ROUTE) }
        )

        // Profile graph
        profileGraph(navController)
    }
}
