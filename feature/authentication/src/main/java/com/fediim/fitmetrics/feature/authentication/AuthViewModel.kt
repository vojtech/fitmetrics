package com.fediim.fitmetrics.feature.authentication

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fediim.fitmetrics.domain.model.AuthStatus
import com.fediim.fitmetrics.domain.usecase.AuthenticateUserUseCase
import com.fediim.fitmetrics.domain.usecase.GetAuthUrlUseCase
import com.fediim.fitmetrics.feature.authentication.state.AuthEvent
import com.fediim.fitmetrics.feature.authentication.state.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.let
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authenticateUserUseCase: AuthenticateUserUseCase,
    private val getAuthUrlUseCase: GetAuthUrlUseCase
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading)

    val uiState = _authState.asStateFlow()

    val authUrl: String
        get() = getAuthUrlUseCase()

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.AuthCodeReceived -> handleAuthCode(event.code)
            AuthEvent.CheckAuthStatus -> checkAuthStatus()
            AuthEvent.InitiateAuth -> initiateAuth()
        }
    }

    fun handleIntent(intent: Intent?) {
        intent?.data?.let { uri ->
            if (uri.host == "vojtech.github.io" &&
                uri.path?.startsWith("/fitbit-stats/fitbit-auth-response") == true
            ) {
                uri.getQueryParameter("code")?.let { code ->
                    onEvent(AuthEvent.AuthCodeReceived(code))
                }
            }
        }
    }

    private fun handleAuthCode(code: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            authenticateUserUseCase
                .authenticateWithCode(code)
                .onSuccess { token ->
                    _authState.value = AuthState.Authenticated
                }.onFailure { error ->
                    _authState.value = AuthState.Error(error)
                }
        }
    }

    private fun checkAuthStatus() {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            when (authenticateUserUseCase.checkAuthStatus()) {
                is AuthStatus.Authenticated -> {
                    _authState.value = AuthState.Authenticated
                }

                AuthStatus.Unauthenticated -> {
                    _authState.value = AuthState.Initial
                }
            }
        }
    }

    private fun initiateAuth() {
        _authState.value = AuthState.Initial
    }
}
