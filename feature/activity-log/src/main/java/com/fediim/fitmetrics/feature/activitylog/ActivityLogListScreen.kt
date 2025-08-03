package com.fediim.fitmetrics.feature.activitylog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fediim.fitmetrics.feature.activitylog.model.ActivityLogFilterUiModel
import com.fediim.fitmetrics.feature.activitylog.model.ActivityLogUiModel
import com.fediim.fitmetrics.feature.activitylog.model.ActivityTypeUiModel
import com.fediim.fitmetrics.feature.activitylog.state.ActivityLogListEvent
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ActivityLogListScreen(
    onNavigateToDetail: (Long) -> Unit,
    onNavigateToProfile: () -> Unit = {},
    viewModel: ActivityLogListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Activity Logs") },
                actions = {
                    IconButton(onClick = onNavigateToProfile) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                    }
                    IconButton(
                        onClick = { viewModel.onEvent(ActivityLogListEvent.ToggleFilterVisibility) }
                    ) {
                        Icon(Icons.Default.FilterList, contentDescription = "Filter")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column {
                // Quick filter chips for activity types
                if (state.activityTypes.isNotEmpty()) {
                    ActivityTypeChips(
                        activityTypes = state.activityTypes,
                        selectedTypeId = state.filter.activityType?.id ?: 0,
                        onActivityTypeSelected = { typeId ->
                            viewModel.onEvent(ActivityLogListEvent.QuickSelectActivityType(typeId))
                        }
                    )
                }

                // Calendar button
                Row(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    OutlinedButton(
                        onClick = {
                            viewModel.onEvent(
                                ActivityLogListEvent.ToggleCalendarVisibility
                            )
                        },
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Icon(
                            Icons.Default.CalendarMonth,
                            contentDescription = "Calendar",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text =
                            if (state.filter.startDate != null && state.filter.endDate != null) {
                                val startDateStr = DateTimeFormatter.ISO_DATE.format(
                                    state.filter.startDate
                                )
                                val endDateStr = DateTimeFormatter.ISO_DATE.format(
                                    state.filter.endDate
                                )
                                "$startDateStr - $endDateStr"
                            } else {
                                "Select Dates"
                            },
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                // Calendar filter
                if (state.filter.isCalendarVisible) {
                    CalendarFilterSection(
                        filter = state.filter,
                        onStartDateChange = { dateStr ->
                            viewModel.onEvent(ActivityLogListEvent.SetStartDate(dateStr))
                        },
                        onEndDateChange = { dateStr ->
                            viewModel.onEvent(ActivityLogListEvent.SetEndDate(dateStr))
                        },
                        onApplyFilter = { updatedFilter ->
                            viewModel.onEvent(ActivityLogListEvent.ApplyFilter(updatedFilter))
                        }
                    )
                }

                if (state.isLoading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else if (state.error != null) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = state.error ?: "Unknown error",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                } else if (state.activities.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No activities found")
                    }
                } else {
                    ActivityList(
                        activities = state.activities,
                        isLoadingMore = state.isLoadingMore,
                        hasMoreItems = state.hasMoreItems,
                        paginationError = state.paginationError,
                        onActivityClick = { activityId ->
                            viewModel.onEvent(ActivityLogListEvent.SelectActivity(activityId))
                            onNavigateToDetail(activityId)
                        },
                        onLoadMore = {
                            viewModel.onEvent(ActivityLogListEvent.LoadMoreActivities)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun FilterSection(
    filter: ActivityLogFilterUiModel,
    onApplyFilter: (ActivityLogFilterUiModel) -> Unit,
    onStartDateChange: (String?) -> Unit,
    onEndDateChange: (String?) -> Unit,
    onActivityTypeChange: (Int) -> Unit,
    activityTypes: List<ActivityTypeUiModel> = emptyList()
) {
    // Initialize with filter values, ensuring they're displayed when the filter section opens
    var startDate by remember(
        filter.startDate
    ) { mutableStateOf(filter.startDate?.toString() ?: "") }
    var endDate by remember(filter.endDate) { mutableStateOf(filter.endDate?.toString() ?: "") }
    var selectedActivityTypeId by remember(filter.activityType) {
        mutableStateOf(filter.activityType?.id ?: 0)
    }

    // Format dates for display
    val displayDateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy")
    val startDateDisplay = filter.startDate?.format(displayDateFormatter) ?: ""
    val endDateDisplay = filter.endDate?.format(displayDateFormatter) ?: ""

    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier =
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Filter Activities",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Start Date Picker
            var showStartDatePicker by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = startDateDisplay.ifEmpty { startDate },
                onValueChange = { /* Read-only field, handled by date picker */ },
                readOnly = true,
                label = { Text("Start Date") },
                trailingIcon = {
                    IconButton(onClick = { showStartDatePicker = true }) {
                        Icon(Icons.Default.CalendarMonth, contentDescription = "Select Date")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            if (showStartDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showStartDatePicker = false },
                    confirmButton = {
                        TextButton(onClick = { showStartDatePicker = false }) {
                            Text("OK")
                        }
                    }
                ) {
                    val datePickerState =
                        rememberDatePickerState(
                            initialSelectedDateMillis = filter.startDate?.toEpochDay()?.times(
                                24 * 60 * 60 * 1000
                            )
                        )

                    DatePicker(
                        state = datePickerState,
                        modifier = Modifier.padding(16.dp)
                    )

                    // Update the date when selected
                    LaunchedEffect(datePickerState.selectedDateMillis) {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val selectedDate = LocalDate.ofEpochDay(millis / (24 * 60 * 60 * 1000))
                            startDate = selectedDate.toString()
                            onStartDateChange(selectedDate.toString())
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // End Date Picker
            var showEndDatePicker by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = endDateDisplay.ifEmpty { endDate },
                onValueChange = { /* Read-only field, handled by date picker */ },
                readOnly = true,
                label = { Text("End Date") },
                trailingIcon = {
                    IconButton(onClick = { showEndDatePicker = true }) {
                        Icon(Icons.Default.CalendarMonth, contentDescription = "Select Date")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            if (showEndDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showEndDatePicker = false },
                    confirmButton = {
                        TextButton(onClick = { showEndDatePicker = false }) {
                            Text("OK")
                        }
                    }
                ) {
                    val datePickerState =
                        rememberDatePickerState(
                            initialSelectedDateMillis = filter.endDate?.toEpochDay()?.times(
                                24 * 60 * 60 * 1000
                            )
                        )

                    DatePicker(
                        state = datePickerState,
                        modifier = Modifier.padding(16.dp)
                    )

                    // Update the date when selected
                    LaunchedEffect(datePickerState.selectedDateMillis) {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val selectedDate = LocalDate.ofEpochDay(millis / (24 * 60 * 60 * 1000))
                            endDate = selectedDate.toString()
                            onEndDateChange(selectedDate.toString())
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Activity Type
            var expanded by remember { mutableStateOf(false) }

            // Find the selected activity type or use the first one if available
            val selectedType =
                if (activityTypes.isNotEmpty()) {
                    activityTypes.find { it.id == selectedActivityTypeId } ?: activityTypes.first()
                } else {
                    ActivityTypeUiModel(0, "All") // Fallback if no types are available
                }

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it }
            ) {
                OutlinedTextField(
                    value = selectedType.name,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    label = { Text("Activity Type") }
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    activityTypes.forEach { type ->
                        DropdownMenuItem(
                            text = { Text(type.name) },
                            onClick = {
                                selectedActivityTypeId = type.id
                                onActivityTypeChange(type.id)
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val newFilter =
                        ActivityLogFilterUiModel(
                            startDate = startDate.takeIf { it.isNotBlank() }?.let {
                                LocalDate.parse(
                                    it
                                )
                            },
                            endDate = endDate.takeIf { it.isNotBlank() }?.let {
                                LocalDate.parse(
                                    it
                                )
                            },
                            activityType = activityTypes.find { it.id == selectedActivityTypeId }
                        )
                    onApplyFilter(newFilter)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Apply Filter")
            }
        }
    }
}

@Composable
fun ActivityList(
    activities: List<ActivityLogUiModel>,
    isLoadingMore: Boolean,
    hasMoreItems: Boolean,
    paginationError: String?,
    onActivityClick: (Long) -> Unit,
    onLoadMore: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(activities) { activity ->
            ActivityItem(
                activity = activity,
                onClick = { onActivityClick(activity.id) }
            )
        }

        // Add loading indicator or load more button at the bottom
        item {
            if (activities.isNotEmpty()) {
                when {
                    isLoadingMore -> {
                        Box(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(32.dp))
                        }
                    }
                    paginationError != null -> {
                        Column(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = paginationError,
                                color = MaterialTheme.colorScheme.error,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(onClick = onLoadMore) {
                                Text("Retry")
                            }
                        }
                    }
                    hasMoreItems -> {
                        // When we reach this item, trigger loading more
                        LaunchedEffect(Unit) {
                            onLoadMore()
                        }

                        Box(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(32.dp))
                        }
                    }
                    else -> {
                        // End of list indicator
                        Box(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No more activities",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ActivityItem(
    activity: ActivityLogUiModel,
    onClick: () -> Unit
) {
    val dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm")

    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier =
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = activity.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = activity.typeId.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = activity.startTime.format(dateFormatter),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Duration",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = activity.duration,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Column {
                    Text(
                        text = "Calories",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "${activity.calories} kcal",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                activity.distance?.let {
                    Column {
                        Text(
                            text = "Distance",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = it,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActivityTypeChips(
    activityTypes: List<ActivityTypeUiModel>,
    selectedTypeId: Int,
    onActivityTypeSelected: (Int) -> Unit
) {
    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        activityTypes.forEach { activityType ->
            val isSelected = activityType.id == selectedTypeId

            FilterChip(
                selected = isSelected,
                onClick = { onActivityTypeSelected(activityType.id) },
                label = { Text(activityType.name) },
                colors =
                FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    }
}

@Composable
fun CalendarFilterSection(
    filter: ActivityLogFilterUiModel,
    onStartDateChange: (String?) -> Unit,
    onEndDateChange: (String?) -> Unit,
    onApplyFilter: (ActivityLogFilterUiModel) -> Unit
) {
    var startDate by remember(filter.startDate) {
        mutableStateOf(filter.startDate?.toString() ?: "")
    }
    var endDate by remember(filter.endDate) {
        mutableStateOf(filter.endDate?.toString() ?: "")
    }

    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier =
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Date Range",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Start Date Picker
            var showStartDatePicker by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = startDate,
                onValueChange = { /* Read-only field, handled by date picker */ },
                readOnly = true,
                label = { Text("Start Date") },
                trailingIcon = {
                    IconButton(onClick = { showStartDatePicker = true }) {
                        Icon(Icons.Default.CalendarMonth, contentDescription = "Select Date")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            if (showStartDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showStartDatePicker = false },
                    confirmButton = {
                        TextButton(onClick = { showStartDatePicker = false }) {
                            Text("OK")
                        }
                    }
                ) {
                    val datePickerState =
                        rememberDatePickerState(
                            initialSelectedDateMillis = filter.startDate?.toEpochDay()?.times(
                                24 * 60 * 60 * 1000
                            )
                        )

                    DatePicker(
                        state = datePickerState,
                        modifier = Modifier.padding(16.dp)
                    )

                    // Update the date when selected
                    LaunchedEffect(datePickerState.selectedDateMillis) {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val selectedDate = LocalDate.ofEpochDay(millis / (24 * 60 * 60 * 1000))
                            startDate = selectedDate.toString()
                            onStartDateChange(selectedDate.toString())
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // End Date Picker
            var showEndDatePicker by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = endDate,
                onValueChange = { /* Read-only field, handled by date picker */ },
                readOnly = true,
                label = { Text("End Date") },
                trailingIcon = {
                    IconButton(onClick = { showEndDatePicker = true }) {
                        Icon(Icons.Default.CalendarMonth, contentDescription = "Select Date")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            if (showEndDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showEndDatePicker = false },
                    confirmButton = {
                        TextButton(onClick = { showEndDatePicker = false }) {
                            Text("OK")
                        }
                    }
                ) {
                    val datePickerState =
                        rememberDatePickerState(
                            initialSelectedDateMillis = filter.endDate?.toEpochDay()?.times(
                                24 * 60 * 60 * 1000
                            )
                        )

                    DatePicker(
                        state = datePickerState,
                        modifier = Modifier.padding(16.dp)
                    )

                    // Update the date when selected
                    LaunchedEffect(datePickerState.selectedDateMillis) {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val selectedDate = LocalDate.ofEpochDay(millis / (24 * 60 * 60 * 1000))
                            endDate = selectedDate.toString()
                            onEndDateChange(selectedDate.toString())
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val newFilter =
                        filter.copy(
                            startDate = startDate.takeIf { it.isNotBlank() }?.let {
                                LocalDate.parse(
                                    it
                                )
                            },
                            endDate = endDate.takeIf { it.isNotBlank() }?.let {
                                LocalDate.parse(
                                    it
                                )
                            },
                            isCalendarVisible = false
                        )
                    onApplyFilter(newFilter)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Apply")
            }
        }
    }
}
