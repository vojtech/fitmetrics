package com.fediim.fitmetrics.feature.activitylog.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fediim.fitmetrics.feature.activitylog.ActivityLogDetailScreen
import com.fediim.fitmetrics.feature.activitylog.ActivityLogListScreen

object ActivityLogDestinations {
    const val ACTIVITY_LOG_ROUTE = "activity_log"
    const val ACTIVITY_LOG_LIST_ROUTE = "$ACTIVITY_LOG_ROUTE/list"
    const val ACTIVITY_LOG_DETAIL_ROUTE = "$ACTIVITY_LOG_ROUTE/detail/{activityId}"

    fun activityLogDetailRoute(activityId: Long): String = "$ACTIVITY_LOG_ROUTE/detail/$activityId"
}

fun NavGraphBuilder.activityLogGraph(
    navController: NavHostController,
    onNavigateToProfile: () -> Unit = {}
) {
    composable(route = ActivityLogDestinations.ACTIVITY_LOG_LIST_ROUTE) {
        ActivityLogListScreen(
            onNavigateToDetail = { activityId ->
                navController.navigate(ActivityLogDestinations.activityLogDetailRoute(activityId))
            },
            onNavigateToProfile = onNavigateToProfile
        )
    }

    composable(
        route = ActivityLogDestinations.ACTIVITY_LOG_DETAIL_ROUTE,
        arguments =
        listOf(
            navArgument("activityId") {
                type = NavType.LongType
            }
        )
    ) { backStackEntry ->
        val activityId = backStackEntry.arguments?.getLong("activityId") ?: 0L
        ActivityLogDetailScreen(
            activityId = activityId,
            onNavigateBack = { navController.popBackStack() }
        )
    }
}

fun NavHostController.navigateToActivityLogList() {
    this.navigate(ActivityLogDestinations.ACTIVITY_LOG_LIST_ROUTE)
}
