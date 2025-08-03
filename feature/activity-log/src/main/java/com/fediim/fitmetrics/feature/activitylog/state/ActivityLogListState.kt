package com.fediim.fitmetrics.feature.activitylog.state

import com.fediim.fitmetrics.feature.activitylog.model.ActivityLogFilterUiModel
import com.fediim.fitmetrics.feature.activitylog.model.ActivityLogUiModel
import com.fediim.fitmetrics.feature.activitylog.model.ActivityTypeUiModel

data class ActivityLogListState(
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val activities: List<ActivityLogUiModel> = emptyList(),
    val activityTypes: List<ActivityTypeUiModel> = emptyList(),
    val isLoadingActivityTypes: Boolean = false,
    val error: String? = null,
    val paginationError: String? = null,
    val filter: ActivityLogFilterUiModel = ActivityLogFilterUiModel(),
    val isFilterVisible: Boolean = false,
    val hasMoreItems: Boolean = true,
    val currentPage: Int = 0
)

sealed class ActivityLogListEvent {
    data object LoadActivities : ActivityLogListEvent()

    data object LoadMoreActivities : ActivityLogListEvent()

    data class ApplyFilter(
        val filter: ActivityLogFilterUiModel
    ) : ActivityLogListEvent()

    data object ToggleFilterVisibility : ActivityLogListEvent()

    data object ToggleCalendarVisibility : ActivityLogListEvent()

    data class SelectActivity(
        val activityId: Long
    ) : ActivityLogListEvent()

    data class SetStartDate(
        val date: String?
    ) : ActivityLogListEvent()

    data class SetEndDate(
        val date: String?
    ) : ActivityLogListEvent()

    data class SetActivityType(
        val typeId: Int
    ) : ActivityLogListEvent()

    data class QuickSelectActivityType(
        val typeId: Int
    ) : ActivityLogListEvent()
}
