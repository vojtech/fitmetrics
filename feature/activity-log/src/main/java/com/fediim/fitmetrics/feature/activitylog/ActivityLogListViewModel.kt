package com.fediim.fitmetrics.feature.activitylog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fediim.fitmetrics.domain.model.ActivityType
import com.fediim.fitmetrics.domain.usecase.ActivityLogUseCases
import com.fediim.fitmetrics.feature.activitylog.mapper.ActivityLogUiMapper
import com.fediim.fitmetrics.feature.activitylog.model.ActivityLogFilterUiModel
import com.fediim.fitmetrics.feature.activitylog.model.ActivityTypeUiModel
import com.fediim.fitmetrics.feature.activitylog.state.ActivityLogListEvent
import com.fediim.fitmetrics.feature.activitylog.state.ActivityLogListState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ActivityLogListViewModel
@Inject
constructor(
    private val activityLogUseCases: ActivityLogUseCases,
    private val mapper: ActivityLogUiMapper
) : ViewModel() {
    // Default filter with no activity type selected yet
    private val defaultFilter =
        ActivityLogFilterUiModel(
            endDate = LocalDate.now(),
            startDate = LocalDate.now().minusWeeks(1),
            activityType = null // Will be set after loading activity types
        )

    private val _state = MutableStateFlow(ActivityLogListState(filter = defaultFilter))
    val state: StateFlow<ActivityLogListState> = _state.asStateFlow()

    private val dateFormatter = DateTimeFormatter.ISO_DATE

    init {
        loadActivityTypes()
        loadActivities()
    }

    private fun loadActivityTypes() {
        viewModelScope.launch {
            _state.update { it.copy(isLoadingActivityTypes = true) }

            activityLogUseCases
                .getActivityTypes()
                .fold(
                    onSuccess = { activityTypes ->
                        val activityTypesUi = activityTypes.map { mapActivityTypeToUi(it) }

                        // If we have activity types, set the first one (All) as default
                        val updatedFilter =
                            if (activityTypesUi.isNotEmpty()) {
                                _state.value.filter.copy(activityType = activityTypesUi.first())
                            } else {
                                _state.value.filter
                            }

                        _state.update {
                            it.copy(
                                activityTypes = activityTypesUi,
                                isLoadingActivityTypes = false,
                                filter = updatedFilter
                            )
                        }
                    },
                    onFailure = { error ->
                        _state.update {
                            it.copy(
                                isLoadingActivityTypes = false,
                                error = error.message ?: "Failed to load activity types"
                            )
                        }
                    }
                )
        }
    }

    private fun mapActivityTypeToUi(domainType: ActivityType): ActivityTypeUiModel =
        ActivityTypeUiModel(
            id = domainType.id,
            name = domainType.name
        )

    // Constants for pagination
    companion object {
        private const val PAGE_SIZE = 20
    }

    fun onEvent(event: ActivityLogListEvent) {
        when (event) {
            is ActivityLogListEvent.LoadActivities -> loadActivities()
            is ActivityLogListEvent.LoadMoreActivities -> loadMoreActivities()
            is ActivityLogListEvent.ApplyFilter -> applyFilter(event.filter)
            is ActivityLogListEvent.ToggleFilterVisibility -> toggleFilterVisibility()
            is ActivityLogListEvent.ToggleCalendarVisibility -> toggleCalendarVisibility()
            is ActivityLogListEvent.SelectActivity -> selectActivity(event.activityId)
            is ActivityLogListEvent.SetStartDate -> setStartDate(event.date)
            is ActivityLogListEvent.SetEndDate -> setEndDate(event.date)
            is ActivityLogListEvent.SetActivityType -> setActivityType(event.typeId)
            is ActivityLogListEvent.QuickSelectActivityType -> quickSelectActivityType(
                event.typeId
            )
        }
    }

    private fun loadActivities() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    error = null,
                    paginationError = null,
                    currentPage = 0,
                    hasMoreItems = true
                )
            }

            val filter = mapper.mapToDomainFilter(_state.value.filter)
            activityLogUseCases
                .getActivityLogs(filter, offset = 0, limit = PAGE_SIZE)
                .fold(
                    onSuccess = { paginatedLogs ->
                        val mappedActivities =
                            paginatedLogs.activities.map { activity ->
                                mapper.mapListItemToUiModel(activity)
                            }

                        _state.update {
                            it.copy(
                                isLoading = false,
                                activities = mappedActivities,
                                hasMoreItems = paginatedLogs.pagination.hasNext,
                                currentPage = 0,
                                // Show a message if there are no activities
                                error =
                                if (mappedActivities.isEmpty() && !paginatedLogs.pagination.hasNext) {
                                    "No activities found for the selected filter"
                                } else {
                                    null
                                }
                            )
                        }
                    },
                    onFailure = { error ->
                        _state.update {
                            it.copy(
                                isLoading = false,
                                error = error.message ?: "Failed to load activities"
                            )
                        }
                    }
                )
        }
    }

    private fun loadMoreActivities() {
        // Don't load more if we're already loading or there are no more items
        if (_state.value.isLoadingMore || !_state.value.hasMoreItems) {
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isLoadingMore = true, paginationError = null) }

            val nextPage = _state.value.currentPage + 1
            val offset = nextPage * PAGE_SIZE

            val filter = mapper.mapToDomainFilter(_state.value.filter)
            activityLogUseCases
                .getActivityLogs(filter, offset = offset, limit = PAGE_SIZE)
                .fold(
                    onSuccess = { paginatedLogs ->
                        val newActivities =
                            paginatedLogs.activities.map { activity ->
                                mapper.mapListItemToUiModel(activity)
                            }

                        _state.update {
                            it.copy(
                                isLoadingMore = false,
                                activities = it.activities + newActivities,
                                // If we got an empty list but the API says there are more items,
                                // something might be wrong, so stop pagination to prevent infinite loading
                                hasMoreItems = paginatedLogs.pagination.hasNext && newActivities.isNotEmpty(),
                                currentPage = nextPage,
                                // Show a warning if we expected more items but got none
                                paginationError =
                                if (paginatedLogs.pagination.hasNext && newActivities.isEmpty()) {
                                    "No more activities found"
                                } else {
                                    null
                                }
                            )
                        }
                    },
                    onFailure = { error ->
                        _state.update {
                            it.copy(
                                isLoadingMore = false,
                                paginationError = error.message ?: "Failed to load more activities"
                            )
                        }
                    }
                )
        }
    }

    private fun applyFilter(filter: ActivityLogFilterUiModel) {
        _state.update { it.copy(filter = filter, isFilterVisible = false) }
        loadActivities()
    }

    private fun toggleFilterVisibility() {
        _state.update { it.copy(isFilterVisible = !it.isFilterVisible) }
    }

    private fun toggleCalendarVisibility() {
        val currentFilter = _state.value.filter
        _state.update {
            it.copy(
                filter =
                currentFilter.copy(
                    isCalendarVisible = !currentFilter.isCalendarVisible
                )
            )
        }
    }

    private fun selectActivity(activityId: Long) {
        // This will be handled by navigation in the UI layer
    }

    private fun quickSelectActivityType(typeId: Int) {
        val activityType = _state.value.activityTypes.find { it.id == typeId }
        val currentFilter = _state.value.filter

        // Update the filter with the selected activity type and apply it immediately
        val updatedFilter = currentFilter.copy(activityType = activityType)
        _state.update { it.copy(filter = updatedFilter) }

        // Reload activities with the new filter
        loadActivities()
    }

    private fun setStartDate(dateString: String?) {
        val date = parseDate(dateString)
        val currentFilter = _state.value.filter
        _state.update {
            it.copy(filter = currentFilter.copy(startDate = date))
        }
    }

    private fun setEndDate(dateString: String?) {
        val date = parseDate(dateString)
        val currentFilter = _state.value.filter
        _state.update {
            it.copy(filter = currentFilter.copy(endDate = date))
        }
    }

    private fun setActivityType(typeId: Int) {
        val activityType = _state.value.activityTypes.find { it.id == typeId }
        val currentFilter = _state.value.filter
        _state.update {
            it.copy(filter = currentFilter.copy(activityType = activityType))
        }
    }

    private fun parseDate(dateString: String?): LocalDate? {
        if (dateString.isNullOrBlank()) return null

        return try {
            LocalDate.parse(dateString, dateFormatter)
        } catch (e: DateTimeParseException) {
            null
        }
    }
}
