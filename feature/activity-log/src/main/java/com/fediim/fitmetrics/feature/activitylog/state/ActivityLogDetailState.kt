package com.fediim.fitmetrics.feature.activitylog.state

import com.fediim.fitmetrics.feature.activitylog.model.ActivityLogUiModel

data class ActivityLogDetailState(
    val isLoading: Boolean = false,
    val activity: ActivityLogUiModel? = null,
    val error: String? = null
)
