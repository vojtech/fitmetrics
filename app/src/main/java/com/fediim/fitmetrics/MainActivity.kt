package com.fediim.fitmetrics

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.fediim.ds.theme.FitTheme
import com.fediim.fitmetrics.feature.authentication.AuthViewModel
import com.fediim.fitmetrics.feature.authentication.state.AuthEvent
import com.fediim.fitmetrics.feature.authentication.state.AuthState
import com.fediim.fitmetrics.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel.onEvent(AuthEvent.CheckAuthStatus)

        splashScreen.setKeepOnScreenCondition { viewModel.uiState.value is AuthState.Loading }

        viewModel.handleIntent(intent)

        setContent {
            FitTheme {
                val navController = rememberNavController()

                AppNavigation(
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                    authViewModel = viewModel
                )
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        viewModel.handleIntent(intent)
    }
}
