package com.fediim.fitmetrics.feature.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.LoadingIndicatorDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fediim.ds.component.FitOutlinedButton
import com.fediim.ds.theme.FitTheme
import com.fediim.ds.util.FitPreview
import com.fediim.fitmetrics.feature.authentication.state.AuthEvent
import com.fediim.fitmetrics.feature.authentication.state.AuthState
import com.fediim.fitmetrics.feature.authentication.util.launchCustomTab

@Composable
fun AuthScreen(
    onAuthSuccess: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val authState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(AuthEvent.CheckAuthStatus)
    }

    LaunchedEffect(authState) {
        if (authState is AuthState.Authenticated) {
            onAuthSuccess()
        }
    }

    AuthScreen(modifier = modifier, state = authState) {
        launchCustomTab(context, viewModel.authUrl)
    }
}

@Composable
fun AuthScreen(modifier: Modifier = Modifier, state: AuthState, authButtonClick: () -> Unit) {
    val screenModifier = modifier.then(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    when (state) {
        AuthState.Initial -> InitialScreen(modifier = screenModifier, onClick = authButtonClick)
        AuthState.Loading -> LoadingScreen(modifier = screenModifier)
        is AuthState.Error -> ErrorMessage(modifier = screenModifier, error = state.error)
        is AuthState.Authenticated -> {}
    }
}

@Composable
private fun InitialScreen(modifier: Modifier, onClick: () -> Unit) {
    Column(
        modifier = modifier.padding(vertical = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            stringResource(com.fediim.localisation.R.string.app_name),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Normal),
            color = MaterialTheme.colorScheme.primary
        )
        Box(
            modifier = Modifier.aspectRatio(1f).background(
                brush = Brush.radialGradient(listOf(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.05f), MaterialTheme.colorScheme.background))
            ),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.ic_logo), contentDescription = "Logo")
        }

        FitOutlinedButton(
            modifier = Modifier,
            shape = MaterialTheme.shapes.large,
            onClick = onClick
        ) {
            Text("Login with Fitbit")
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun LoadingScreen(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LoadingIndicator(
            polygons = LoadingIndicatorDefaults.IndeterminateIndicatorPolygons.take(2)
        )
    }
}

@Composable
private fun ErrorMessage(modifier: Modifier, error: Throwable) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Error: ${error.message}",
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@FitPreview
@Composable
private fun AuthScreenInitialPreview() {
    FitTheme {
        AuthScreen(state = AuthState.Initial) {
        }
    }
}

@FitPreview
@Composable
private fun AuthScreenAuthenticatedPreview() {
    FitTheme {
        AuthScreen(state = AuthState.Authenticated) {
        }
    }
}

@FitPreview
@Composable
private fun AuthScreenAuthenticatingPreview() {
    FitTheme {
        AuthScreen(state = AuthState.Loading) {
        }
    }
}

@FitPreview
@Composable
private fun AuthScreenErrorPreview() {
    FitTheme {
        AuthScreen(state = AuthState.Error(Throwable())) {
        }
    }
}
