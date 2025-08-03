package com.fediim.fitmetrics.domain.usecase

import javax.inject.Inject

data class ActivityLogUseCases @Inject constructor(
    val getActivityLogs: GetActivityLogsUseCase,
    val getActivityLogById: GetActivityLogByIdUseCase,
    val getActivityTypes: GetActivityTypesUseCase
)
