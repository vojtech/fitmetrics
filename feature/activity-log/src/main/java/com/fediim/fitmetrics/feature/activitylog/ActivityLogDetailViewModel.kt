package com.fediim.fitmetrics.feature.activitylog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fediim.fitmetrics.domain.usecase.ActivityLogUseCases
import com.fediim.fitmetrics.feature.activitylog.mapper.ActivityLogUiMapper
import com.fediim.fitmetrics.feature.activitylog.state.ActivityLogDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ActivityLogDetailViewModel @Inject constructor(
    private val activityLogUseCases: ActivityLogUseCases,
    private val mapper: ActivityLogUiMapper
) : ViewModel() {
    private val _state = MutableStateFlow(ActivityLogDetailState())
    val state: StateFlow<ActivityLogDetailState> = _state.asStateFlow()

    fun loadActivityDetail(activityId: Long) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            activityLogUseCases
                .getActivityLogById(activityId)
                .fold(
                    onSuccess = { activity ->
                        _state.update {
                            it.copy(
                                isLoading = false,
                                activity = mapper.mapDetailToUiModel(activity)
                            )
                        }
                    },
                    onFailure = { error ->
                        _state.update {
                            it.copy(
                                isLoading = false,
                                error = error.message ?: "Failed to load activity details"
                            )
                        }
                    }
                )
        }
    }
}
