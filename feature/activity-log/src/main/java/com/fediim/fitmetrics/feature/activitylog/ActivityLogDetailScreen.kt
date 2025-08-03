package com.fediim.fitmetrics.feature.activitylog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fediim.fitmetrics.feature.activitylog.model.ActivityLogUiModel
import java.time.format.DateTimeFormatter

@Composable
fun ActivityLogDetailScreen(
    activityId: Long,
    onNavigateBack: () -> Unit,
    viewModel: ActivityLogDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(activityId) {
        viewModel.loadActivityDetail(activityId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Activity Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
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
            when {
                state.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                state.error != null -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = state.error ?: "Unknown error",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
                state.activity != null -> {
                    ActivityDetailContent(activity = state.activity!!)
                }
            }
        }
    }
}

@Composable
fun ActivityDetailContent(activity: ActivityLogUiModel) {
    val dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm")

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Activity Name and Type
        Text(
            text = activity.name,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = activity.typeId.toString(),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Date and Time
        DetailSection(
            title = "Date & Time",
            content = activity.startTime.format(dateFormatter)
        )

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        // Stats Section
        Text(
            text = "Activity Stats",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Duration
        DetailSection(
            title = "Duration",
            content = activity.duration
        )

        // Calories
        DetailSection(
            title = "Calories Burned",
            content = "${activity.calories} kcal"
        )

        // Distance (if available)
        activity.distance?.let {
            DetailSection(
                title = "Distance",
                content = it
            )
        }

        // Steps (if available)
        activity.steps?.let {
            DetailSection(
                title = "Steps",
                content = it
            )
        }

        // Heart Rate (if available)
        activity.heartRate?.let {
            DetailSection(
                title = "Average Heart Rate",
                content = it
            )
        }
    }
}

@Composable
fun DetailSection(
    title: String,
    content: String
) {
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
